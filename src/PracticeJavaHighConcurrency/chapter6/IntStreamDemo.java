package PracticeJavaHighConcurrency.chapter6;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class IntStreamDemo {
    static int[] arr = {56, 4, 8, 12, 0, 30};

    public static void main(String[] args) {
        f6();
    }

    public static void f1() {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void f2() {
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }

    public static void f3() {
        Arrays.stream(arr).forEach((final int x) -> {
            System.out.println(x);
        });
    }

    public static void f4() {
        Arrays.stream(arr).forEach((x) -> {
            System.out.println(x);
        });
    }

    public static void f5() {
        Arrays.stream(arr).forEach((x) -> System.out.println(x));
    }

    public static void f6() {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void chain() {
        IntConsumer outp = System.out::println;
        IntConsumer errp = System.err::println;

        Arrays.stream(arr).forEach(outp.andThen(errp));
    }

}
