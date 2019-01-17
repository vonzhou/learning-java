package jvm.ch08execute;

/**
 * 静态多分配，动态单分配
 *
 public static void main(java.lang.String[]);
 descriptor: ([Ljava/lang/String;)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=3, args_size=1
 0: new           #2                  // class com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Father
 3: dup
 4: invokespecial #3                  // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Father."<init>"                    :()V
 7: astore_1
 8: new           #4                  // class com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Son
 11: dup
 12: invokespecial #5                  // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Son."<init>":()                    V
 15: astore_2
 16: aload_1
 17: new           #6                  // class com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Wechat
 20: dup
 21: invokespecial #7                  // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Wechat."<init>"                    :()V
 24: invokevirtual #8                  // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Father.hardChoi                    ce:(Lcom/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Wechat;)V
 27: aload_2
 28: new           #9                  // class com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$QQ
 31: dup
 32: invokespecial #10                 // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$QQ."<init>":()V
 35: invokevirtual #11                 // Method com/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$Father.hardChoi                    ce:(Lcom/vonzhou/learn/jvm/ch08execute/SingleMultiDispatch$QQ;)V
 38: return

 * @version 2018/2/23.
 */
public class SingleMultiDispatch {
    static class QQ {
    }

    static class Wechat {
    }

    public static class Father {
        public void hardChoice(QQ qq) {
            System.out.println("father choose qq");
        }

        public void hardChoice(Wechat w) {
            System.out.println("father choose Wechat");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ qq) {
            System.out.println("son choose qq");
        }

        public void hardChoice(Wechat w) {
            System.out.println("son choose Wechat");
        }
    }

    public static void main(String[] args) {
        Father f = new Father();
        Father son = new Son();
        f.hardChoice(new Wechat());
        son.hardChoice(new QQ());
    }
}
