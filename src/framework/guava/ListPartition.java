package framework.guava;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author vonzhou
 * @date 2019/1/20
 */
public class ListPartition {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        List<List<Integer>> parts = Lists.partition(numbers, 3);
        System.out.println(parts);
    }
}
