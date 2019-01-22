package collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vonzhou on 2017/6/11.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }

    /**
     * Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
     */
    public static void test2() {
        List<String> list = new ArrayList<>();
        list.add("dog");

        Object[] oa = list.toArray();//其实此时数组类型已为 [Ljava.lang.Object;
        System.out.println(((String) oa[0]).length());
        String[] sa = (String[]) oa; // 所以此时会抛出 ClassCastException
    }

    public static void test1() {
        // 是Arrays内部类ArrayList，而不是java.util.ArrayList
        List<String> list = Arrays.asList("hello");

        System.out.println(list.toArray().getClass());

        Object[] oa = list.toArray();
        String[] sa = (String[]) oa;// ok


        String[] strArr = new String[1];
        System.out.println(strArr instanceof Object[]); // true
        System.out.println(new ArrayListDemo[0] instanceof Object[]); // true
    }

    public static void test3() {
        List<String> list = Lists.newArrayList();
        list.add("hello");

        List<String> sub = list.subList(0, 1);
        sub.add(1, "hello2");
        System.out.println();
    }


}
