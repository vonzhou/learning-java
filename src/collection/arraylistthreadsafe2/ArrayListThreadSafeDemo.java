package collection.arraylistthreadsafe2;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author vonzhou
 * @version 2018/9/7
 */
public class ArrayListThreadSafeDemo {
    public static void notThreadSafe() throws Exception {
        final List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        list.add(new Random().nextInt(100));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 30);

        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }

    public static void useSynchronized() throws Exception {
        final List<Integer> list = Collections.synchronizedList(Lists.newArrayList());
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        list.add(new Random().nextInt(100));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 30);

        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }

    public static void iter(List<Integer> list) {
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    public static void iterWithLock() {
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("apple");
        list.add("mi");
        list.add("huawei");

        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
    }

    public static void useCOW() throws Exception {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        list.add(String.format("T%s-%s",Thread.currentThread().getId(), j));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 10);
        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }

    public static void main(String[] args) throws Exception {
//        notThreadSafe();
        useSynchronized();
//        useCOW();
    }

}
