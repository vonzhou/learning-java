package jvm;

/**
 * P57
 * <p>
 * JDK8运行结果： true, false
 * <p>
 * https://www.zhihu.com/question/51102308
 *
 * @version 2018/2/7.
 */
public class StringIntern {
    public static void main(String[] args) {
//        test();
//    test2();
//        test3();
        test4();
    }

    private static void test() {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();

        System.out.println(s2.intern() == s2);
    }

    public static void test2() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));//true
        System.out.println(str5 == str3);//false
        System.out.println(str5.intern() == str3);//true
        System.out.println(str5.intern() == str4);//false
    }

    public static void test3() {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e; // 计算得到的，只是存储在栈中？

        System.out.println(b.intern() == a);//fasle
        System.out.println(b.intern() == c);//true
        System.out.println(b.intern() == d);//true  编译期d已确定(修改、赋值)为ab
        System.out.println(b.intern() == f);//false
        System.out.println(b.intern() == a.intern());//true
    }

    public static void test4() {
        // 编译期已确定
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(a == d);//true
        System.out.println(a == e);//true
        System.out.println(c == d);//true
        System.out.println(c == e);//true
    }
}
