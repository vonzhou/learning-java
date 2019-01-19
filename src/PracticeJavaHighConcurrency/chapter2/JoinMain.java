package PracticeJavaHighConcurrency.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        public void run() {
            System.out.println("add!");
            for (i = 0; i < 1000000; i++) ;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        AddThread at = new AddThread();
        at.start();
        at.join();//ʹ��join()������,���̻߳�ȴ�AddThreadִ�����,i���Ϊ1000000,���û���������,i���Ϊ0
        //���Բ鿴join�ĵײ����,���ʼ��õ����߳��ڵ�ǰ�̶߳���ʵ���ϵȴ�
        System.out.println(i);
    }
}
