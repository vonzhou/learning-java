package framework.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * https://dzone.com/articles/cglib-missing-manual
 * @version 2017/7/21.
 */
public class Test3 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "hello cglib";
                } else {
                    // 调用原始方法
                    return proxy.invokeSuper(obj, args);
                }
            }
        });

        SampleClass proxy = (SampleClass) enhancer.create();

        System.out.println(proxy.test(null));

        System.out.println(proxy.toString());

        System.out.println(proxy.hashCode()); // OK
    }
}
