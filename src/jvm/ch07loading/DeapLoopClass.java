package jvm.ch07loading;

/**
 * @author vonzhou
 * @date 2019/1/17
 */
public class DeapLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " initing ......");
            while (true) {
                ;
            }
        }
    }


    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeapLoopClass c = new DeapLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
    }
}
