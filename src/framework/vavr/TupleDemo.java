package framework.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class TupleDemo {
    public static void main(String[] args) {
        // (Java, 8)
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);

// "Java"
        String s = java8._1;

// 8
        Integer i = java8._2;
    }
}
