package PracticeJavaHighConcurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 13 on 2017/5/5.
 */
public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);//����trueָ�����ǹ�ƽ��,Ҳ���Բ�����,�ֱ����й۲칫ƽ����ǹ�ƽ���������
    //public static ReentrantLock unfairLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                // unfairLock.lock();
                System.out.println(Thread.currentThread().getName() + "�����");
            } finally {
                fairLock.unlock();
                // unfairLock.unlock();
            }
        }
    }

    /**
     * ��ƽ����һ���ص���:���������������,ֻҪ�Ŷ����ն���õ���Դ.
     * <p/>
     * ����ʵ�ֹ�ƽ��Ҫ��ϵͳά��һ���������,��˹�ƽ����ʵ�ֳɱ��ϸ�,������Ե���.
     *
     * @param args
     */
    public static void main(String args[]) {
        FairLock r1 = new FairLock();
        Thread thread1 = new Thread(r1, "Thread_t1");
        Thread thread2 = new Thread(r1, "Thread_t2");
        Thread thread3 = new Thread(r1, "Thread_t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
