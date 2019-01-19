package PracticeJavaHighConcurrency.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class PriorityDemo {
    public static class HightPriority extends Thread {
        static int count = 0;

        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {//�˴�������Դ����
                    count++;
                    if (count > 1000000) {
                        System.out.println("HightPriority is complete!");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread {
        static int count = 0;

        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {//�˴�������Դ����
                    count++;
                    if (count > 1000000) {
                        System.out.println("LowPriority is complete!");
                        break;
                    }
                }
            }
        }
    }


    /**
     * �����ȼ����߳�������,���ǲ����ܱ�֤ÿ�ζ���LowPriority�����,��Դ����������»��ǻ���ȷ�����ȼ��ϸߵ��̻߳����Դ.
     *
     * @param args
     */
    public static void main(String args[]) {
        Thread high = new HightPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();

    }

}
