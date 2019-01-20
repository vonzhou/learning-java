# Collections工具类源码阅读


## 二分查找 binarySearch

列表必须是递增排序的,针对是否是可随机访问的列表,根据索引定位元素的方法不同.

有两点可以学习:
* 移位实现除以2
* 如果没有找到,返回的是 -(应该插入的位置)

```java
public static <T>
    int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        // 可随机访问,或者尺寸小于5000
        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
            return Collections.indexedBinarySearch(list, key);
        else
            return Collections.iteratorBinarySearch(list, key);
    }

    private static <T>
    int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // 这里
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    private static <T>
    int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key)
    {
        int low = 0;
        int high = list.size()-1;
        ListIterator<? extends Comparable<? super T>> i = list.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = get(i, mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
```

## 排序 sort

TimSort

## 逆转 reverse


* 如果是基于数组的,或者长度小于18,则直接前后交换
* 否则,链表操作

```java
public static void reverse(List<?> list) {
        int size = list.size();
        if (size < REVERSE_THRESHOLD || list instanceof RandomAccess) {
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {
            // instead of using a raw type here, it's possible to capture
            // the wildcard but it will require a call to a supplementary
            // private method
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }
```

```java
public static void swap(List<?> list, int i, int j) {
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }
```


针对ArrayList,LinkedList设值的实现分别是:

```java
public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }
```

```java
public E set(int index, E element) {
        checkElementIndex(index);
        // 定位
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

   // 从距离近的一端开始找起
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

## shuffle

## 填充 fill

## 拷贝 copy

## 最小值 min

## 最大值 max

## 旋转 rotate

## 替换元素 replaceAll

## 定位子列表 indexOfSubList

## 包装为不可变列表


##

