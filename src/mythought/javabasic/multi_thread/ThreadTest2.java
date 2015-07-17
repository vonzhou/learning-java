package mythought.javabasic.multi_thread;

public class ThreadTest2 {
	public static void main(String[] args) {
		Thread t=new Thread(new Mythread());
		t.start();
	}

}

class Mythread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println(i);
		}
	}
}
