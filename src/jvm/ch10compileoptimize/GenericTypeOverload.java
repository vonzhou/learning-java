package jvm.ch10compileoptimize;

import java.util.Arrays;
import java.util.List;

/**
 * 当泛型遇到重载
 * @version 2018/2/24.
 */
public class GenericTypeOverload {
    // 'method(List<String>)' clashes with 'method(List<Integer>)'; both methods have same erasure
//    public static void method(List<String> list) {
//    }

    public static String method(List<String> list) {
        return "";
    }

//    public static int method(List<Integer> list) {
//        return 1;
//    }

    public static void main(String[] args) {
        method(Arrays.asList("1"));
    }

}
