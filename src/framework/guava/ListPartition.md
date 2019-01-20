# Guava列表分片实现(Lists.partition)

Lists.partition 是通过提供一层抽象来实现分片的，通过 get 返回一个子列表，子列表具体有 subList 来实现。

```java
public static <T> List<List<T>> partition(List<T> list, int size) {
checkNotNull(list);
checkArgument(size > 0);
return (list instanceof RandomAccess)
    ? new RandomAccessPartition<T>(list, size)
    : new Partition<T>(list, size);
}

private static class Partition<T> extends AbstractList<List<T>> {
    final List<T> list;
    final int size;

    Partition(List<T> list, int size) {
      this.list = list;
      this.size = size;
    }
    // 映射到底层subList
    @Override public List<T> get(int index) {
      checkElementIndex(index, size());
      int start = index * size;
      int end = Math.min(start + size, list.size());
      return list.subList(start, end);
    }
    // 根据分片大小得到最终的分片个数
    @Override public int size() {
      return IntMath.divide(list.size(), size, RoundingMode.CEILING);
    }

    @Override public boolean isEmpty() {
      return list.isEmpty();
    }
}

// 实现同上，但是声明实现 RandomAccess， 最终体现到get方法的不同
private static class RandomAccessPartition<T> extends Partition<T>
  implements RandomAccess {
    RandomAccessPartition(List<T> list, int size) {
      super(list, size);
    }
}
```

最终的关键操作在于subList:

```
// java.util.AbstractList
public List<E> subList(int fromIndex, int toIndex) {
    return (this instanceof RandomAccess ?
            new RandomAccessSubList<>(this, fromIndex, toIndex) :
            new SubList<>(this, fromIndex, toIndex));
}
```

SubList 的逻辑同样是在原有的 List 上包装一层抽象：

```java
class SubList<E> extends AbstractList<E> {
    private final AbstractList<E> l;
    private final int offset;
    private int size;

    SubList(AbstractList<E> list, int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > list.size())
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                               ") > toIndex(" + toIndex + ")");
        l = list;
        offset = fromIndex;
        size = toIndex - fromIndex;
        this.modCount = l.modCount;
    }

    public E set(int index, E element) {
        rangeCheck(index);
        checkForComodification();
        return l.set(index+offset, element);
    }

    public E get(int index) {
        rangeCheck(index);
        checkForComodification();
        return l.get(index+offset);
    }

    public int size() {
        checkForComodification();
        return size;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        checkForComodification();
        l.add(index+offset, element);
        this.modCount = l.modCount;
        size++;
    }

    public E remove(int index) {
        rangeCheck(index);
        checkForComodification();
        E result = l.remove(index+offset);
        this.modCount = l.modCount;
        size--;
        return result;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        checkForComodification();
        l.removeRange(fromIndex+offset, toIndex+offset);
        this.modCount = l.modCount;
        size -= (toIndex-fromIndex);
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        int cSize = c.size();
        if (cSize==0)
            return false;

        checkForComodification();
        l.addAll(offset+index, c);
        this.modCount = l.modCount;
        size += cSize;
        return true;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return new SubList<>(this, fromIndex, toIndex);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    // 只能修改该子列表
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkForComodification() {
        if (this.modCount != l.modCount)
            throw new ConcurrentModificationException();
    }
}

class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
    RandomAccessSubList(AbstractList<E> list, int fromIndex, int toIndex) {
        super(list, fromIndex, toIndex);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return new RandomAccessSubList<>(this, fromIndex, toIndex);
    }
}
```

在 modCount 一致的情况下，对 SubList 的操作最终都会体现在底层的 List 上。这里通过get方法可以看到是否实现 RandomAccess 接口的区别。

ArrayList 获取某个位置的元素：

```
// 直接存取
public E get(int index) {
    rangeCheck(index);

    return elementData(index);
}

E elementData(int index) {
    return (E) elementData[index];
}

/**
 * The array buffer into which the elements of the ArrayList are stored.
 * The capacity of the ArrayList is the length of this array buffer. Any
 * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
 * will be expanded to DEFAULT_CAPACITY when the first element is added.
 */
transient Object[] elementData; // non-private to simplify nested class access
```

LinkedList 获取某个位置的元素：

```java
public E get(int index) {
    checkElementIndex(index);
    return node(index).item;
}
// 遍历链表，从最近一端开始遍历
Node<E> node(int index) {
    // assert isElementIndex(index);

    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```