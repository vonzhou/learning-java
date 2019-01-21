package lang;

/**
 * ThreadLocal 继承问题
 * Created by vonzhou on 2019/1/21.
 */
public class ThreadLocalInheritDemo {
    //    private ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void test() throws InterruptedException {
        threadLocal.set("parent");

        // 开启一个子线程
        Thread childThread = new Thread(() -> {
            System.out.println(Thread.currentThread() + ": " + threadLocal.get());
            threadLocal.set("child");
            System.out.println(Thread.currentThread() + ": " + threadLocal.get());
        });

        childThread.start();

        childThread.join();

        System.out.println(Thread.currentThread() + ": " + threadLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadLocalInheritDemo().test();
    }
}
