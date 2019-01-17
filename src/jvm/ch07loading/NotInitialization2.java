package jvm.ch07loading;

/**
 * P212
 * 被动使用类演示2:通过数组定义来引用类,不会触发该类的初始化.
 * <p>
 * Created by vonzhou on 2018/2/20.
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sa = new SuperClass[10];
    }
}
