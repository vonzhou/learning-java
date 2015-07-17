package mythought.javabasic.multi_thread;

public class Sample {
	private int number;
	public synchronized void increase(){
		while(0!=number){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number++;
		System.out.println(number);
		notify();
	}
	public synchronized void decrease(){
		while(0==number){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number--;
		System.out.println(number);
		notify();
	}

}
