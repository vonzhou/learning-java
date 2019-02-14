package lang.enumsingleton;

import java.io.*;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class SingletonSerializationDemo {

    public static void main(String[] args) {
        // 对于Singleton2, 对于Singleton3 表现是一样的
        Singleton1 obj1 = Singleton1.INSTANCE;
        Singleton1 obj2 = Singleton1.INSTANCE;
        System.out.println(obj1 == obj2 ? "Two objects are same" : "Two objects are different");

        // 序列化 obj1
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.ser"));
            out.writeObject(obj1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Singleton1 obj3 = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.ser"));
            obj3 = (Singleton1) in.readObject();
            in.close();
        } catch (Exception i) {
            i.printStackTrace();
        }

        System.out.println(obj1 == obj3 ? "Two objects are same" : "Two objects are different");
    }
}
