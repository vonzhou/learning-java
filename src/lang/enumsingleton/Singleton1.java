package lang.enumsingleton;

import java.io.Serializable;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class Singleton1 implements Serializable {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    // 注释掉该方法， 进行对比
//    protected Object readResolve() {
//        return INSTANCE;
//    }
}
