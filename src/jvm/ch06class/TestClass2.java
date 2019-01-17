package jvm.ch06class;

/**
 * 验证：静态变量类型的字段会存在 ConstantValue 属性
 * @version 2018/2/12.
 */
public class TestClass2 {
    private final static int m = 123;

    public int inc() {
        return m + 1;
    }
}
