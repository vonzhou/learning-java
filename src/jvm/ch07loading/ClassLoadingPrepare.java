package jvm.ch07loading;

/**
 * 准备阶段
 *
 * @author vonzhou
 * @date 2019/1/17
 */
public class ClassLoadingPrepare {
    // 准备阶段的时候设置的是0，初始化（<clinit>）的时候才设置为100
    private static int a = 100;

    // 具有 ConstantValue 属性，准备阶段的时候就是设置为99
    private static final int b = 99;
}
