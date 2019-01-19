package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author vonzhou
 * @version 2018/9/26
 */
public class GenericCollection {

    public static void main(String[] args) {
        System.out.println(new ArrayList<String>().getClass());
        System.out.println(new ArrayList<Object>().getClass());
        System.out.println("------------");
        List<String> list = Arrays.asList("f1", "f2");
        FooTemplate<Object> fooTemplate = new FooTemplate<>();
        fooTemplate.foo(list);
        System.out.println("------------");
        FooTemplate<String> fooTemplate1 = new FooTemplate<>();
        fooTemplate1.foo(list);
        System.out.println("------------");

        StringFooTemplate stringFooTemplate = new StringFooTemplate();
        stringFooTemplate.foo(list);

        System.out.println("------------");
        fooTemplate.foo((List)list);
    }

    public static class FooTemplate<K> {
        public void foo(K k) {
            System.out.println("foo : " + k);
        }

        public void foo(Collection<K> ks) {
            System.out.println("foos : " + ks.toString());
        }
    }

    public static class StringFooTemplate extends FooTemplate<String> {

    }

    public static void cannot(){
//        List<String> stringList = new ArrayList<String>;
//        List<Object> objectList = stringList;
//        objectList.add(new Object());
//        String s = stringList.get(0);// attempt to assign an Object to a String :O

        Object o = new GenericCollection();
        String s = "str";


    }


}
