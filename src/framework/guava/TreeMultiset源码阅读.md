# Guava TreeMultiset 源码阅读


>  崇祯五年十二月，余住西湖。大雪三日，湖中人鸟声俱绝。是日更定矣，余拏一小舟，拥毳衣炉火，独往湖心亭看雪。雾凇沆砀，天与云与山与水，上下一白。湖上影子，惟长堤一痕、湖心亭一点、与余舟一芥、舟中人两三粒而已。
  到亭上，有两人铺毡对坐，一童子烧酒炉正沸。见余，大喜曰：“湖中焉得更有此人？”拉余同饮。余强饮三大白而别。问其姓氏，是金陵人，客此。及下船，舟子喃喃曰：“莫说相公痴，更有痴似相公者！”
  – 《湖心亭看雪》(明)张岱

  Guava项目是谷歌java的核心库，包括集合，缓存，原语，并发，注解，字符串，IO处理等，现在在github上有八千多个star，很早就听说过，但是一直没有去学习，是时候开始了，guava读[ˈɡwɑvə]，番石榴 。最新的版本是19.0，发布于December 9, 2015。


  从哪里开始呢？不重要，重要的是你要action。前几日师弟问我了一个简单的问题“要读word进行字典排序，java中自然就会想到有序集合，把words存入TreeSet中，然后输出，不就是有序了吗，为何测试用例不通过；但是把words放入vector中，然后使用collections.sort方法就是OK的，为何？为何？”，后来得知问题的关键在于words可能会重复，那么TreeSet无法解决这种问题，TreeSet基于HashMap，没用C++里面的multimap，这就是问题的关键。所以如果遇到这种应用场景，就需要自己实现一个multimap，Guava中提供了，所以看看具体实现。

  初步跟踪了一下，没那么简单，我得静一会！

  TreeMultiset: create，add方法。底层的操作就是AVL树的操作。

  ```java
  private final transient Reference<AvlNode<E>> rootReference; // Reference保证了对tree的操作同步

    private final transient GeneralRange<E> range;
    private final transient AvlNode<E> header;

  	// 创建一个tree multiset对象，比较器是自然顺序
    public static <E extends Comparable> TreeMultiset<E> create() {
      return new TreeMultiset<E>(Ordering.natural());
    }

     // 修饰符不是public，所以只能通过create方法构建对象, Builder模式
     TreeMultiset(Comparator<? super E> comparator) {
      super(comparator);
      this.range = GeneralRange.all(comparator);
      this.header = new AvlNode<E>(null, 1);
      successor(header, header);   // 构造一个根节点，里面的element不存在
      this.rootReference = new Reference<AvlNode<E>>();
    }

  @Override
    public int add(@Nullable E element, int occurrences) {
      if (occurrences == 0) {
        return count(element);
      }
      checkArgument(range.contains(element));
      AvlNode<E> root = rootReference.get();
      if (root == null) {
        // 和自身比较意欲何为？我唯一能想到的是防止element为空，通过这可以抛出NullPointerException
        comparator().compare(element, element);
        AvlNode<E> newRoot = new AvlNode<E>(element, occurrences);
        successor(header, newRoot, header);
        rootReference.checkAndSet(root, newRoot);
        return 0;
      }
      // 这里
      int[] result = new int[1]; // used as a mutable int reference to hold result  学习下这种引用的技巧
      AvlNode<E> newRoot = root.add(comparator(), element, occurrences, result);
      // AVL插入会涉及旋转，所以最后重新设置root node
      rootReference.checkAndSet(root, newRoot);
      return result[0];
    }
  ```

  TreeMultiset.AvlNode: AvlNode的作用就是把一个Entry包装成一个tree中的节点，为了保证插入过程的平衡，还要在每个node中记录该子树的高度height。

  ```java
  private static final class AvlNode<E> extends Multisets.AbstractEntry<E> {
      @Nullable private final E elem;

      // elemCount is 0 iff this node has been deleted.
      private int elemCount;

      private int distinctElements;
      private long totalCount;
      private int height;
      private AvlNode<E> left;
      private AvlNode<E> right;
      private AvlNode<E> pred;
      private AvlNode<E> succ;

      AvlNode(@Nullable E elem, int elemCount) {
        checkArgument(elemCount > 0);
        this.elem = elem;
        this.elemCount = elemCount;
        this.totalCount = elemCount;
        this.distinctElements = 1;
        this.height = 1;
        this.left = null;
        this.right = null;
      }

  	 // 在以该node代表的tree中查找和e满足comparator关系的元素个数，很实用的一个抽象，递归实现
      public int count(Comparator<? super E> comparator, E e) {
        int cmp = comparator.compare(e, elem);
        if (cmp < 0) {
          return (left == null) ? 0 : left.count(comparator, e);
        } else if (cmp > 0) {
          return (right == null) ? 0 : right.count(comparator, e);
        } else {
          return elemCount;
        }
      }
  	// addRightChild，addLeftChild针对的是在左右子树为空的时候插入的简单情景
      private AvlNode<E> addRightChild(E e, int count) {
        right = new AvlNode<E>(e, count);
        successor(this, right, succ);
        height = Math.max(2, height);
        distinctElements++;
        totalCount += count;
        return this;
      }

      private AvlNode<E> addLeftChild(E e, int count) {
        left = new AvlNode<E>(e, count);
        successor(pred, left, this);
        height = Math.max(2, height);
        distinctElements++;
        totalCount += count;
        return this;
      }
  	// 重点理解这里
      AvlNode<E> add(Comparator<? super E> comparator, @Nullable E e, int count, int[] result) {
        /*
         * It speeds things up considerably to unconditionally add count to totalCount here,
         * but that destroys failure atomicity in the case of count overflow. =(
         */
        int cmp = comparator.compare(e, elem);
        if (cmp < 0) {
          AvlNode<E> initLeft = left;
          if (initLeft == null) {
            result[0] = 0;
            return addLeftChild(e, count);
          }
          int initHeight = initLeft.height;

          left = initLeft.add(comparator, e, count, result);
          if (result[0] == 0) {
            distinctElements++;
          }
          this.totalCount += count;
          return (left.height == initHeight) ? this : rebalance();
        } else if (cmp > 0) {
        	  // 到这里说明要在右子树中插入这个e
          AvlNode<E> initRight = right;
          if (initRight == null) {
           	// 如果右子树为空，很好，直接把这个元素挂上，更新前继后继即可
            result[0] = 0;
            return addRightChild(e, count);
          }
          int initHeight = initRight.height;
  		 // 递归的进行
          right = initRight.add(comparator, e, count, result);
          // 这里体现了result这个引用参数的重要性，返回为0，表明我们确实增加了一个unique的元素
          if (result[0] == 0) {
            distinctElements++;
          }
          this.totalCount += count;
          // 看是否需呀重新平衡
          return (right.height == initHeight) ? this : rebalance();
        }
  		// 到这里说明增加的元素和我的值一样，只需要更新count就行了，无需rebalance
        // adding count to me!  No rebalance possible.
        result[0] = elemCount; // 保存之前元素的次数，通过result值-结果参数返回
        long resultCount = (long) elemCount + count;
        checkArgument(resultCount <= Integer.MAX_VALUE);
        this.elemCount += count;
        this.totalCount += count;
        return this;
      }

      AvlNode<E> setCount(Comparator<? super E> comparator, @Nullable E e, int count, int[] result) {
        int cmp = comparator.compare(e, elem);
        if (cmp < 0) {
          AvlNode<E> initLeft = left;
          if (initLeft == null) {
            result[0] = 0;
            return (count > 0) ? addLeftChild(e, count) : this;
          }

          left = initLeft.setCount(comparator, e, count, result);

          if (count == 0 && result[0] != 0) {
            this.distinctElements--;
          } else if (count > 0 && result[0] == 0) {
            this.distinctElements++;
          }

          this.totalCount += count - result[0];
          return rebalance();
        } else if (cmp > 0) {
          AvlNode<E> initRight = right;
          if (initRight == null) {
            result[0] = 0;
            return (count > 0) ? addRightChild(e, count) : this;
          }

          right = initRight.setCount(comparator, e, count, result);

          if (count == 0 && result[0] != 0) {
            this.distinctElements--;
          } else if (count > 0 && result[0] == 0) {
            this.distinctElements++;
          }

          this.totalCount += count - result[0];
          return rebalance();
        }

        // setting my count
        result[0] = elemCount;
        if (count == 0) {
          return deleteMe();
        }
        this.totalCount += count - elemCount;
        this.elemCount = count;
        return this;
      }

      AvlNode<E> setCount(
          Comparator<? super E> comparator,
          @Nullable E e,
          int expectedCount,
          int newCount,
          int[] result) {
        int cmp = comparator.compare(e, elem);
        if (cmp < 0) {
          AvlNode<E> initLeft = left;
          if (initLeft == null) {
            result[0] = 0;
            if (expectedCount == 0 && newCount > 0) {
              return addLeftChild(e, newCount);
            }
            return this;
          }

          left = initLeft.setCount(comparator, e, expectedCount, newCount, result);

          if (result[0] == expectedCount) {
            if (newCount == 0 && result[0] != 0) {
              this.distinctElements--;
            } else if (newCount > 0 && result[0] == 0) {
              this.distinctElements++;
            }
            this.totalCount += newCount - result[0];
          }
          return rebalance();
        } else if (cmp > 0) {
          AvlNode<E> initRight = right;
          if (initRight == null) {
            result[0] = 0;
            if (expectedCount == 0 && newCount > 0) {
              return addRightChild(e, newCount);
            }
            return this;
          }

          right = initRight.setCount(comparator, e, expectedCount, newCount, result);

          if (result[0] == expectedCount) {
            if (newCount == 0 && result[0] != 0) {
              this.distinctElements--;
            } else if (newCount > 0 && result[0] == 0) {
              this.distinctElements++;
            }
            this.totalCount += newCount - result[0];
          }
          return rebalance();
        }

        // setting my count
        result[0] = elemCount;
        if (expectedCount == elemCount) {
          if (newCount == 0) {
            return deleteMe();
          }
          this.totalCount += newCount - elemCount;
          this.elemCount = newCount;
        }
        return this;
      }

      private void recomputeMultiset() {
        this.distinctElements =
            1 + TreeMultiset.distinctElements(left) + TreeMultiset.distinctElements(right);
        this.totalCount = elemCount + totalCount(left) + totalCount(right);
      }

      private void recomputeHeight() {
        this.height = 1 + Math.max(height(left), height(right));
      }

      private void recompute() {
        recomputeMultiset();
        recomputeHeight();
      }

      private AvlNode<E> rebalance() {
        switch (balanceFactor()) {
          case -2:
            if (right.balanceFactor() > 0) {
              right = right.rotateRight();
            }
            return rotateLeft();
          case 2:
            if (left.balanceFactor() < 0) {
              left = left.rotateLeft();
            }
            return rotateRight();
          default:
            recomputeHeight();
            return this;
        }
      }

      private int balanceFactor() {
        return height(left) - height(right);
      }

      private AvlNode<E> rotateLeft() {
        checkState(right != null);
        AvlNode<E> newTop = right;
        this.right = newTop.left;
        newTop.left = this;
        newTop.totalCount = this.totalCount;
        newTop.distinctElements = this.distinctElements;
        this.recompute();
        newTop.recomputeHeight();
        return newTop;
      }

      private AvlNode<E> rotateRight() {
        checkState(left != null);
        AvlNode<E> newTop = left;
        this.left = newTop.right;
        newTop.right = this;
        newTop.totalCount = this.totalCount;
        newTop.distinctElements = this.distinctElements;
        this.recompute();
        newTop.recomputeHeight();
        return newTop;
      }

      private static long totalCount(@Nullable AvlNode<?> node) {
        return (node == null) ? 0 : node.totalCount;
      }

      private static int height(@Nullable AvlNode<?> node) {
        return (node == null) ? 0 : node.height;
      }

      @Override
      public E getElement() {
        return elem;
      }

      @Override
      public int getCount() {
        return elemCount;
      }

      @Override
      public String toString() {
        return Multisets.immutableEntry(getElement(), getCount()).toString();
      }
    }
  ```

Multiset.AbstractEntry: 对Multiset.Entry中的equals，hashCode，toString这三个通用函数做了具体实现。

```java
abstract static class AbstractEntry<E> implements Multiset.Entry<E> {

    @Override
    public boolean equals(@Nullable Object object) {
      if (object instanceof Multiset.Entry) {
        Multiset.Entry<?> that = (Multiset.Entry<?>) object;
        return this.getCount() == that.getCount()
            && Objects.equal(this.getElement(), that.getElement());
      }
      return false;
    }

    @Override
    public int hashCode() {
      E e = getElement();
      return ((e == null) ? 0 : e.hashCode()) ^ getCount();
    }

    @Override
    public String toString() {
      String text = String.valueOf(getElement());
      int n = getCount();
      return (n == 1) ? text : (text + " x " + n);
    }
  }
```

Multiset.Entry: 用于multiset的element-count pair，Multiset.entrySet()方法返回的就是关于该multiset的一个视图，然后用于遍历，虽然和Map.Entry没用关系，但是思路一样。

```java
interface Entry<E> {

  /**
   * 返回和这个Entry对应的元素对象
   */
  E getElement();

  /**
   * 因为是multiset所以不同的key可以出现多次，所以count用于记录该element的次数
   */
  int getCount();

  /**
   * 两个Entry的equal条件，element和count都要一样
   *   Objects.equal(a.getElement(), b.getElement()) && a.getCount() == b.getCount()}
   */
  @Override
  // TODO(kevinb): check this wrt TreeMultiset?
  boolean equals(Object o);

  /**
   * 该Entry的hash code，需要纳入element和count
   *   ((element == null) ? 0 : element.hashCode()) ^ count}
   */
  @Override
  int hashCode();

  /**
   * 展示形式，如果element出现一次，则直接是element的toString()形式
   * 否则就乘以对应的次数
   */
  @Override
  String toString();
}
```

## 总结：

* 底层结构AVL
* 通过count记录重复元素，避免多次存储，可以想象着里面的tradeoff

> vonzhou 2016-3-26 HUST


