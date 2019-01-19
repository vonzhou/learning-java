package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vonzhou
 * @date 2019/1/9
 */
public class TODO {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
//        s.add("a");
//        s.add(null);


        List<String> list = new ArrayList<>();
        list.add("xxx");
        list.clear();
        list.addAll(s);
        System.out.println(s);


        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(list);
                    System.out.println(list);
                    System.out.println(list);
                    System.out.println(list);
                    System.out.println(list);
                }
            }).start();
        }


        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.clear();
                    list.add("xxxx");
                    list.add("a");
                    list.add("b");
                    list.add("c");
                    list.add("d");
                }
            }).start();
        }

    }
}
