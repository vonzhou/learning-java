package PracticeJavaHighConcurrency.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        Comparator<String> cmp = Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);

        List<String> list = Arrays.asList("abd", "Abc", "b", "ABCD");
        list.sort(cmp);
        System.out.println(list);
    }
}
