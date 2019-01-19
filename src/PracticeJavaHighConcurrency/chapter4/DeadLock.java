package PracticeJavaHighConcurrency.chapter4;

/**
 * Created by 13 on 2017/5/6.
 */
public class DeadLock extends Thread {
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object object) {
        this.tool = object;

        if (tool == fork1) {
            this.setName("哲学家A");
        }
        if (tool == fork2) {
            this.setName("哲学家B");
        }
    }

    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork2) {
                    System.out.println("哲学家A开始就餐了");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork1) {
                    System.out.println("哲学家B开始就餐了");
                }
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        DeadLock lock1 = new DeadLock(fork1);
        DeadLock lock2 = new DeadLock(fork2);

        lock1.start();
        lock2.start();

        Thread.sleep(1000);
    }
}
