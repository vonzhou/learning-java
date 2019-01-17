package jvm.ch10compileoptimize;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * P315
 * 
 * @version 2018/2/24.
 */
public class Autoboxing {

    /**
     descriptor: ()V
     flags: ACC_PUBLIC, ACC_STATIC
     Code:
     stack=4, locals=4, args_size=0
     0: iconst_2
     1: anewarray     #2                  // class java/lang/Integer
     4: dup
     5: iconst_0
     6: iconst_1
     7: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     10: aastore
     11: dup
     12: iconst_1
     13: iconst_2
     14: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     17: aastore
     18: invokestatic  #4                  // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util                                                                                             /List;
     21: astore_0
     22: iconst_0
     23: istore_1
     24: aload_0
     25: invokeinterface #5,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
     30: astore_2
     31: aload_2
     32: invokeinterface #6,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
     37: ifeq          60
     40: aload_2
     41: invokeinterface #7,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
     46: checkcast     #2                  // class java/lang/Integer
     49: invokevirtual #8                  // Method java/lang/Integer.intValue:()I
     52: istore_3
     53: iload_1
     54: iload_3
     55: iadd
     56: istore_1
     57: goto          31
     60: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
     63: iload_1
     64: invokevirtual #10                 // Method java/io/PrintStream.println:(I)V
     67: return
    
     */
    public static void f1() {
        // 语法糖：泛型，自动装箱，变长参数
        List<Integer> list = Arrays.asList(1, 2);
        int sum = 0;
        // 语法糖：遍历容器，自动拆箱
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     public static void f2();
     descriptor: ()V
     flags: ACC_PUBLIC, ACC_STATIC
     Code:
     stack=4, locals=4, args_size=0
     0: iconst_2
     1: anewarray     #2                  // class java/lang/Integer
     4: dup
     5: iconst_0
     6: iconst_1
     7: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     10: aastore
     11: dup
     12: iconst_1
     13: iconst_2
     14: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     17: aastore
     18: invokestatic  #4                  // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util                                                                                             /List;
     21: astore_0
     22: iconst_0
     23: istore_1
     24: aload_0
     25: invokeinterface #5,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
     30: astore_2
     31: aload_2
     32: invokeinterface #6,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
     37: ifeq          60
     40: aload_2
     41: invokeinterface #7,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
     46: checkcast     #2                  // class java/lang/Integer
     49: invokevirtual #8                  // Method java/lang/Integer.intValue:()I
     52: istore_3
     53: iload_1
     54: iload_3
     55: iadd
     56: istore_1
     57: goto          31
     60: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
     63: iload_1
     64: invokevirtual #10                 // Method java/io/PrintStream.println:(I)V
     67: return
    
     */
    public static void f2() {
        List<Integer> list = Arrays.asList(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)});
        int sum = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            int t = (Integer) iterator.next();
            sum += t;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
