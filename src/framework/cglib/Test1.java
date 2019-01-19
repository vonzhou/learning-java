package framework.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * https://dzone.com/articles/cglib-missing-manual
 * @version 2017/7/21.
 */
public class Test1 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });

        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println(proxy.toString());

        // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Number
//        System.out.println(proxy.hashCode());

        // final方法不能被拦截
        System.out.println(proxy.getClass());


    }
}
