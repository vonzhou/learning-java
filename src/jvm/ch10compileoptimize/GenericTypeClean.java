package jvm.ch10compileoptimize;

import java.util.HashMap;
import java.util.Map;

/**
 * P312
 * 泛型擦除
 * 
 *
 public static void f1();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=1, args_size=0
 0: new           #2                  // class java/util/HashMap
 3: dup
 4: invokespecial #3                  // Method java/util/HashMap."<init>":()V
 7: astore_0
 8: aload_0
 9: ldc           #4                  // String name
 11: ldc           #5                  // String zhangsan
 13: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
 18: pop
 19: return
 LineNumberTable:
 line 13: 0
 line 14: 8
 line 15: 19
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 8      12     0   map   Ljava/util/Map;
 LocalVariableTypeTable:
 Start  Length  Slot  Name   Signature
 8      12     0   map   Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;

 public static void f2();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=1, args_size=0
 0: new           #2                  // class java/util/HashMap
 3: dup
 4: invokespecial #3                  // Method java/util/HashMap."<init>":()V
 7: astore_0
 8: aload_0
 9: ldc           #4                  // String name
 11: ldc           #5                  // String zhangsan
 13: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
 18: pop
 19: return
 LineNumberTable:
 line 18: 0
 line 19: 8
 line 20: 19
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 8      12     0   map   Ljava/util/Map;


 * @version 2018/2/24.
 */
public class GenericTypeClean {
    public static void f1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zhangsan");
    }

    public static void f2() {
        Map map = new HashMap();
        map.put("name", "zhangsan");
    }

    public static void main(String[] args) {
        f1();
    }
}
