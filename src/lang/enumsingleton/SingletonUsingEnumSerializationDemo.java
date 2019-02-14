package lang.enumsingleton;

import java.io.*;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class SingletonUsingEnumSerializationDemo {
    public static void main(String[] args) {
        SingletonUsingEnum obj1 = SingletonUsingEnum.INSTANCE;

        // 序列化 obj1
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.ser"));
            out.writeObject(obj1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        SingletonUsingEnum obj3 = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.ser"));
            obj3 = (SingletonUsingEnum) in.readObject();
            in.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
        System.out.println(obj1 == obj3 ? "Two objects are same" : "Two objects are different");
    }
}
