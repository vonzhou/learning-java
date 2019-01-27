package framework.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class TupleDemo {
    public static void main(String[] args) {
        Tuple2<String, Integer> tuple = Tuple.of("Java", 8);
        System.out.println(tuple._1);
    }
}
