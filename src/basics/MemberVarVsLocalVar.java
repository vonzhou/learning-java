package basics;

/**
 * 成员变量，局部变量的区别
 *
 * @author vonzhou
 * @date 2019/1/14
 */
public class MemberVarVsLocalVar {

    private int a;

    int b;

    public void f(final int c) {
        int d;
        System.out.println(a);
        System.out.println(c);
        // 局部变量必须要显示的初始化
//        System.out.println(d);
    }


    public static void main(String[] args) {
        new MemberVarVsLocalVar().f(34);
    }

}
