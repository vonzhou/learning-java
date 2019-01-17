package jvm.ch02memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 *
 * @version 2018/2/8.
 */
public class DirectMemoryOOM {
    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);

        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
