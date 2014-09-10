package multi_thread;

public class DecreaseThread extends Thread{
	private Sample sample;

	public DecreaseThread(Sample sample) {
		this.sample = sample;
	}
	
	@Override
	public  void run() {
		try {
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
		}
		for(int i=0;i<20;i++){
			sample.decrease();
		}
	}
	
}
