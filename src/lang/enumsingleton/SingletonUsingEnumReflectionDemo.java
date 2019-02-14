package lang.enumsingleton;

import java.lang.reflect.Constructor;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class SingletonUsingEnumReflectionDemo {
    public static void main(String[] args) throws Exception {
        SingletonUsingEnum obj1 = SingletonUsingEnum.INSTANCE;
        Constructor constructor = obj1.getClass().getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        SingletonUsingEnum obj2 = (SingletonUsingEnum) constructor.newInstance();
        System.out.println(obj1 == obj2 ? "Two objects are same" : "Two objects are different");
    }
}
