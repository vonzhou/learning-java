package lang;

/**
 * @version 2018/2/5.
 */
public class StringDemo {
    public static void main(String[] args) {
        testIntern();
    }

    public static void testIntern() {
        String s = new String("1");
        String s2 = "1";
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        s3.intern(); // 放入String常量池中了
        String s4 = "11";
        System.out.println(s3 == s4);

        String s5 = new String("2") + new String("2");
        String s6 = "22";
        s3.intern();
        System.out.println(s5 == s6);
    }

    public static void testSubString() {
        String a = "hello";
        System.out.println(a.substring(0, 5) == a);
        System.out.println(a.substring(0, 4) == a);
    }
}
