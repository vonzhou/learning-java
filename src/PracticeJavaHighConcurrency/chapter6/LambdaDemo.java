package PracticeJavaHighConcurrency.chapter6;

import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        int num = 3;
//        final int num = 3;
        Function<Integer, Integer> multiByNum = (from) -> {
//            num ++;
            return from * num;
        };
        System.out.println(multiByNum.apply(3));
    }
}
