package jvm.ch08execute;

/**
 * P247
 * 方法静态分配

 Code:
 stack=2, locals=4, args_size=1
 0: new           #7                  // class com/vonzhou/learn/jvm/ch08execute/StaticDispatch$Man
 3: dup
 4: invokespecial #8                  // Method com/vonzhou/learn/jvm/ch08execute/StaticDispatch$Man."<init>":()V
 7: astore_1
 8: new           #9                  // class com/vonzhou/learn/jvm/ch08execute/StaticDispatch$Woman
 11: dup
 12: invokespecial #10                 // Method com/vonzhou/learn/jvm/ch08execute/StaticDispatch$Woman."<init>":()V
 15: astore_2
 16: new           #11                 // class com/vonzhou/learn/jvm/ch08execute/StaticDispatch
 19: dup
 20: invokespecial #12                 // Method "<init>":()V
 23: astore_3
 24: aload_3
 25: aload_1
 26: invokevirtual #13                 // Method sayHello:(Lcom/vonzhou/learn/jvm/ch08execute/StaticDispatch$Human;)V
 29: aload_3
 30: aload_2
 31: invokevirtual #13                 // Method sayHello:(Lcom/vonzhou/learn/jvm/ch08execute/StaticDispatch$Human;)V
 34: return


 * @version 2018/2/23.
 */
public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello, guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello, gentleman");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello, lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
