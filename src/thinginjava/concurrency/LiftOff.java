package thinginjava.concurrency;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int baseCount = 0;
	private final int id = baseCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ") ";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();// the current thread is willing to yield its current
							// use of a processor
		}

	}

}
