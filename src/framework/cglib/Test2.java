package framework.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * https://dzone.com/articles/cglib-missing-manual
 * @version 2017/7/21.
 */
public class Test2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "hello cglib";
                } else {
                    throw new RuntimeException("Do not know what to do.");
                }
            }
        });

        SampleClass proxy = (SampleClass) enhancer.create();

        System.out.println(proxy.test(null));

        System.out.println(proxy.toString());
    }
}
