package jvm.ch08execute;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * P262
 * MethodHandle 基本用法
 *
 * @version 2018/2/23.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("[ClassA ]" + s);
        }
    }


    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("hello method handle");
    }

    private static MethodHandle getPrintlnMH(Object obj) throws Exception {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);

    }
}
