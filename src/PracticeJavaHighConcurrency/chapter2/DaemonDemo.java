package PracticeJavaHighConcurrency.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class DaemonDemo {
    public static class DaemonT extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * thread������Ϊ�ػ��߳�,ϵͳ��ֻ�����߳�mainΪ�û��߳�,�����main�߳�����3���˳�ʱ,��������Ҳ��֮����,��������߳�thread����Ϊ�ػ��߳�,
     * main�߳̽�����,t�̻߳��᲻ͣ�Ĵ�ӡ,��ԶҲ�������.
     *
     * tip:��һ��JavaӦ����,ֻ���ػ��߳�ʱ,Java������ͻ��˳�.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new DaemonT();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);

    }
}
