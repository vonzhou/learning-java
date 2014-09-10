package basic.juc;

class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int duration) {
		super(name); // set this thread's name
		this.duration = duration;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println();
		}
	}
}

public class Joining {

}
