package jvm.ch02memory;

import java.util.ArrayList;
import java.util.List;

/**
 * P51 堆内存OOM测试
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\\
 * @version 2018/2/7.
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
