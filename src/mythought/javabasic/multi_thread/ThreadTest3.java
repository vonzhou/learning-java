package mythought.javabasic.multi_thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		Runnable r=new Thread3();
		//当用同一个Runnable对象创建线程时，如果是成员变量，线程会相互影响
		//打印的次数不等于60,而是不确定的 (<=60)
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		//Thread t3=new Thread(r);
		t1.start();
		t2.start();
		//t3.start();
	}

}

class Thread3 implements Runnable{
	int i;
	@Override
	public void run() {
		//int i=0;
		while(true){
			System.out.println("NUMBER: "+(i++));
			
			try {
				Thread.sleep(100);//当时间变大时同样出现问题
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(20==i){break;}
		}
	}
}
