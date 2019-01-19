package PracticeJavaHighConcurrency.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @see java.util.concurrent.ArrayBlockingQueue
 * Created by 13 on 2017/5/5.
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println(String.format("条件满足，线程%s运行！", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();
        Thread thread1 = new Thread(reenterLockCondition);
        thread1.setName("T1");
        thread1.start();
        Thread.sleep(2000);
        System.out.println("通知T1条件满足");
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
