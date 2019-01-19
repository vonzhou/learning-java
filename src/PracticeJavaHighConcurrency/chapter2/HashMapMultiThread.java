package PracticeJavaHighConcurrency.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13 on 2017/5/4.
 */
public class HashMapMultiThread {
    static Map<String, String> map = new HashMap<String, String>();

    public static class AddThread implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    /**
     *  HashMap��һ���̲߳���ȫ������,���̲߳���ʱ����ֳ�ͻ
     *
     *  jdk7�½������д˷���,���ܻᵼ�µ�������,jdk8���������޸�
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread(0));
        Thread thread2 = new Thread(new AddThread(1));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map.size());
    }
}
