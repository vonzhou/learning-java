package mythought.javabasic.multi_thread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1=new Thread1();
		Thread t2=new Thread2("hello");
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.start();
		t2.start();
	}

}

class Thread1 extends Thread{
	public Thread1(){}
	public Thread1(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("ÌìÑÄ"+i);
		}
	}
}
	class Thread2 extends Thread{
		public Thread2(){}
		public Thread2(String name){
			super(name);
		}
		@Override
		public void run() {
			for(int i=0;i<50;i++){
				System.out.println("ÌìÑÄ"+i);
			}
		}
	}

