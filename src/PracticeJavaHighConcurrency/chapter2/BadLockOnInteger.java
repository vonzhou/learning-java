package PracticeJavaHighConcurrency.chapter2;

/**
 * ����һ������ļ�����ʽ
 * <p/>
 * Created by 13 on 2017/5/4.
 */
public class BadLockOnInteger implements Runnable {

    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

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
        for (int j = 0; j < 1000000; j++) {
            synchronized (i) {//����ͬ���Ĳ�����ͬһ������,��Ϊi����Integer�ؼ��ִ�����
                //��ȷ����Ӧ���� synchronized (instance)
                i++;
            }
        }
    }

    /**
     * �õ��Ľ��������2000000,�ڶ��̵߳Ĳ����г����˴���
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
