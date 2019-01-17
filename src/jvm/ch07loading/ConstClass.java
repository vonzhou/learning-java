package jvm.ch07loading;

/**
 * Created by vonzhou on 2018/2/20.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO = "hello world";
}
