package jvm.ch07loading;

/**
 * P213
 * 被动使用类演示3:编译阶段通过常量传播优化,对常量的引用不会触发该类的初始化.
 * <p>
 * Created by vonzhou on 2018/2/20.
 */
public class NotInitialization3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO);
    }
}
