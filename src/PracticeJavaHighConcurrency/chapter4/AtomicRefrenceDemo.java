package PracticeJavaHighConcurrency.chapter4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicRefrenceDemo {

    //�����п��ܲ�����������ᵽ�����
    public static void main(String args[]) {
        final AtomicReference<Integer> money = new AtomicReference<Integer>();
        money.set(19);

        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        Integer m = money.get();
                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20)) {
                                System.out.println("���С��20Ԫ,��ֵ�ɹ�,���:" + money.get() + "Ԫ");
                                break;
                            }
                        } else {
                            System.out.println("������20,�����ֵ");
                            break;
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {

                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("������10Ԫ");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("�ɹ�����10Ԫ,���:" + money.get() + "Ԫ");
                                break;
                            }
                        } else {
                            System.out.println("û���㹻�Ľ��");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
