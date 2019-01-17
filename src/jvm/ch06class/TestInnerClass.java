package jvm.ch06class;

/**
 * 验证：内部类的字节码结构
 * @version 2018/2/12.
 */
public class TestInnerClass {
    private final static int m = 123;

    public int inc() {
        return m + 1;
    }

    public class InnerClass {
        public int inc2() {
            return inc();
        }
    }
}
