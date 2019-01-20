package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vonzhou
 * @date 2019/1/20
 */
public class CollectionsSort {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(435,43,234,9,324,33);
        Collections.sort(lst);
        System.out.println(lst);
    }
}
