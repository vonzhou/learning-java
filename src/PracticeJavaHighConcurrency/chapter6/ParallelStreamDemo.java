package PracticeJavaHighConcurrency.chapter6;


import util.PrimeUtil;

import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        f1();
        f2();
    }

    private static void f1() {
        long start = System.currentTimeMillis();
        IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();
        System.out.println(String.format("f1 cost %s ms", System.currentTimeMillis() - start));
    }

    private static void f2() {
        long start = System.currentTimeMillis();
        IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
        System.out.println(String.format("f2 cost %s ms", System.currentTimeMillis() - start));
    }


}
