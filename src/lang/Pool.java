package lang;

/**
 * static 变量最终会转换为static块进行执行
 *
 * static final 的变量会放在常量池中， 可能会被直接替换优化
 *
 *
 *
 *
 * 通过 javac, javap -v分析
 *
 * @version 2018/2/6.
 */
public class Pool {
    static final int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
