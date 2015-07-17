package mythought.javabasic.multi_thread;

public class ThreadTest5 {
	public static void main(String[] args) {
		Fruit2 fruit=new Fruit2();
		
		Thread t1=new Thread5(fruit);
		Thread t2=new Thread52(fruit);
		
		t1.start();
		t2.start();
	}

}

class Fruit2{
	private Object obj=new Object();
	public void kind(){
		synchronized(this){//可以锁定任何对象如obj
			for(int i=0;i<20;i++){
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("apple: "+i);}
		
		}
	}
	public void kind2(){
		synchronized(this){
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
}

class Thread5 extends Thread{
	private Fruit2 fruit;
	
	public Thread5(Fruit2 fruit) {
		this.fruit = fruit;
	}

	@Override
	public void run() {
		fruit.kind();
	}
}
class Thread52 extends Thread{
	private Fruit2 fruit;
	
	public Thread52(Fruit2 fruit) {
		this.fruit = fruit;
	}
	
	@Override
	public void run() {
		fruit.kind2();
	}
}





































