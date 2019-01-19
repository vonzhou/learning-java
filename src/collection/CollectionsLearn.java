package collection;

import java.util.*;

/**
 * @version 2017/6/27.
 */
public class CollectionsLearn {
    public static void main(String[] args) {
//        typeCheck();
        rotate();
    }


    public static void rotate(){
        List<Integer> ints = Arrays.asList(1, 2, 3,4,5,6);
        Collections.rotate(ints, -1);
        System.out.println(ints);

    }

    public static void typeCheck() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        addOther(list, 5);
        list.add("demo");
        System.out.println(list);

        list = new ArrayList<>();
        list = Collections.checkedList(list, String.class);
        list.add("hello");
        addOther(list, 6);
        System.out.println(list);

    }

    public static void addOther(List list, int a) {
        list.add(a);
    }

    public static void f() {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.contains(null));

        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set.contains(null));
    }

}
