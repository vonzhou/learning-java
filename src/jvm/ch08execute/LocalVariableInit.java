package jvm.ch08execute;

/**
 * 局部变量必须显示初始化
 * @version 2018/2/23.
 */
public class LocalVariableInit {
    public static void main(String[] args) {
//        int a ; // 编译不通过
        int a = 0;
        System.out.println(a);
    }
}
