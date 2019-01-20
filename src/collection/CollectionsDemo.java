package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vonzhou on 2019/1/20.
 */
public class CollectionsDemo {
    public static void main(String[] args) {
//        search();
        reverse();
    }

    private static void reverse() {
        List<Integer> lst = Arrays.asList(435, 43, 234, 9, 324, 33);
        Collections.reverse(lst);
        System.out.println(lst);
    }

    private static void search() {
        List<Integer> lst = Arrays.asList(435, 43, 234, 9, 324, 33);

        Collections.sort(lst);

        int res = Collections.binarySearch(lst, 43);
        System.out.println(res);

        res = Collections.binarySearch(lst, 3);
        System.out.println(res);
    }
}
