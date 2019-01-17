package jvm.ch08execute;

import java.io.Serializable;

/**
 * 选择目标方法的过程
 * @version 2018/2/23.
 */
public class Overload {
    public static void sayHello(Object c) {
        System.out.println("hello Object");
    }

    public static void sayHello(int c) {
        System.out.println("hello int");
    }

    public static void sayHello(long c) {
        System.out.println("hello long");
    }

    public static void sayHello(Character c) {
        System.out.println("hello Character");
    }

    public static void sayHello(char c) {
        System.out.println("hello char");
    }

    public static void sayHello(char... c) {
        System.out.println("hello char...");
    }

    public static void sayHello(Serializable c) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
