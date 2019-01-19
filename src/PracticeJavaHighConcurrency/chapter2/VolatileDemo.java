package PracticeJavaHighConcurrency.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class VolatileDemo {
    static volatile int i = 0;

    public static class PlusTask implements Runnable {

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
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    /**
     * volatile��֤�����Ŀɼ���,�����޷���֤һЩ���ϲ�����ԭ����,��ʵ���Ｔ�ܵõ��˽��,����10���̶߳�i�����ۼӲ���,
     * ���һ�������Ļ�,���ӦΪ100000,���ǽ��Ϊ94875��������С��100000,����̵߳Ĳ�����û�б�֤i��ԭ����.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[100];
        for (int j = 0; j < 100; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }
        for (int j = 0; j < 100; j++) {
            threads[j].join();
        }
        System.out.println(i);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("��ʱ:" + time);
    }
}
