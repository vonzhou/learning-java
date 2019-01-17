package jvm.ch07loading;

import java.io.IOException;
import java.io.InputStream;

/**
 * P228
 * 不同类加载器对 instanceof 结果的影响
 *
 * @version 2018/2/23.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    // 这里很重要，defineClass() -> defineClass1() 会触发对 Object.class 的加载，需要父加载器完成
                    // 否则报错：java.lang.ClassNotFoundException: Object.class
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] bs = new byte[is.available()];
                    is.read(bs);

                    return defineClass(name, bs, 0, bs.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myClassLoader.loadClass("jvm.ch07loading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());

        // 本类是由 AppClassLoader 加载的
        System.out.println(obj instanceof ClassLoaderTest); // false
    }
}
