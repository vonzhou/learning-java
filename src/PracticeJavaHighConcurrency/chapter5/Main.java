package PracticeJavaHighConcurrency.chapter5;

/**
 * Created by 13 on 2017/5/8.
 */
public class Main {
    public static void main(String args[]) {
        Client client = new Client();
        //�������������,��Ϊ�õ�����FutureData������RealData
        Data data = client.request("name");
        System.out.println("�������");

        try {

            //������һ��sleep�����˶�����ҵ���߼��Ĵ���
            //�ڴ�����Щҵ���߼��Ĺ�����,RealData������,�Ӷ���������˵ȴ�ʱ��
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ʹ����ʵ������
        System.out.println("����=" + data.getResult());
    }
}
