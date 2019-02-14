package lang.enumsingleton;

import java.lang.reflect.Constructor;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class SingletonReflectionDemo {
    public static void main(String[] args) throws Exception {
        Singleton1 obj1 = Singleton1.INSTANCE;
        // 得到无参构造器
        Constructor constructor = obj1.getClass().getDeclaredConstructor(new Class[0]);
        // 这里使私有构造器可以访问
        constructor.setAccessible(true);
        Singleton1 obj2 = (Singleton1) constructor.newInstance();
        System.out.println(obj1 == obj2 ? "Two objects are same" : "Two objects are different");
    }
}
