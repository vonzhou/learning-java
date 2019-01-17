package jvm.ch08execute;

/**
 * P252
 * 动态分配，重写



 * @version 2018/2/23.
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        protected void sayHello() {
            System.out.println("hello, gentleman");

        }
    }

    static class Woman extends Human {
        protected void sayHello() {
            System.out.println("hello, lady");

        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
