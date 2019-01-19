package lang;

/**
 * @author vonzhou
 * @date 2018/12/19
 */
public class IntegerCacheDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Integer a = 1; // 等价于 Integer a = valueOf(1)
        Integer b = 1;
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        System.out.println(c.equals(d));
    }

}
