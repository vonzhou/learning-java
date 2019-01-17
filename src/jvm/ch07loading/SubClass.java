package jvm.ch07loading;

/**
 * Created by vonzhou on 2018/2/20.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
