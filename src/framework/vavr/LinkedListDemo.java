package framework.vavr;

import io.vavr.collection.List;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = list1.tail().prepend(0);

    }
}
