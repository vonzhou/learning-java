package network;

public class Singleton {
	private static Singleton singleton;
	private Singleton(){}
	public static Singleton getInstance(){
		if(null==singleton){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singleton=new Singleton();
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
		
	}

}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(Singleton.getInstance());
		super.run();
	}
}
