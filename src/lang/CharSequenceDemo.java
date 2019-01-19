package lang;

/**
 * @version 2018/2/2.
 */
public class CharSequenceDemo {
    public static void main(String[] args) {
        info("abc");
        info("中文"); // \u4e2d\u6587
    }

    public static void info(String s) {
        System.out.println(s.length());
        System.out.println(s.getBytes().length);
        System.out.println(s.charAt(1));
    }
}
