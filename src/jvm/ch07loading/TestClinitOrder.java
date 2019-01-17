package jvm.ch07loading;

/**
 * P226
 * 父类的clinit方法先执行
 * Created by vonzhou on 2018/2/21.
 */
public class TestClinitOrder {
    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
