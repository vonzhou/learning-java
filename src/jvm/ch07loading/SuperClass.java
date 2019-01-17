package jvm.ch07loading;

/**
 * Created by vonzhou on 2018/2/20.
 */
public class SuperClass {
    public static int VAL = 123;

    static {
        System.out.println("SuperClass init!");
    }
}
