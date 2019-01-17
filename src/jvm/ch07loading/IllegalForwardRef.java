package jvm.ch07loading;

/**
 * 非法向前引用
 *
 * @author vonzhou
 * @date 2019/1/17
 */
public class IllegalForwardRef {


    static {
        i = 0; // 能编译通过
//        System.out.println(i); // illegal forward reference
    }

    static int i = 1;


    public static void main(String[] args) {

    }


}
