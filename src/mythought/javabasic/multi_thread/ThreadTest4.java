package mythought.javabasic.multi_thread;

public class ThreadTest4 {
	public static void main(String[] args) {
		Fruit fruit=new Fruit();
		
		Thread t1=new Thread4(fruit);
		//fruit=new Fruit();
		Thread t2=new Thread42(fruit);
		t1.start();
		t2.start();
	}

}

class Fruit{
	public synchronized  void kind(){//锁定的是该对象
		for(int i=0;i<20;i++){
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("apple: "+i);
		}
	}
	public synchronized static void kind2(){//锁定的是对应的class对象
		for(int i=0;i<20;i++){
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("orange: "+i);
		}
	}
}

class Thread4 extends Thread{
	private Fruit fruit;
	
	public Thread4(Fruit fruit) {
		this.fruit = fruit;
	}

	@Override
	public void run() {
		fruit.kind();
	}
}
class Thread42 extends Thread{
	private Fruit fruit;
	
	public Thread42(Fruit fruit) {
		this.fruit = fruit;
	}
	
	@Override
	public void run() {
		fruit.kind2();
	}
}





































