package jvm.ch06class;

/**
 * @version 2018/2/12.
 */
public class TestExceptionTable {
    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            System.out.println("final....");
        }
    }

    public static void main(String[] args) {
        TestExceptionTable testExceptionTable = new TestExceptionTable();
        System.out.println(testExceptionTable.inc());
    }
}
