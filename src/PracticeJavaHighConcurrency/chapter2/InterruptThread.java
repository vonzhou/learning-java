package PracticeJavaHighConcurrency.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class InterruptThread {
    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Running!");
                    Thread.yield();
                }
            }
        };

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();//�����жϲ���,���Ǵ˲���û���κ�Ӱ��
    }
}
