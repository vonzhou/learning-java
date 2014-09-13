package javathreadprogramming.chapter5;

public class AlternateStop extends Object implements Runnable {
	private volatile boolean stopRequested;
	private Thread runThread;

	public void run() {
		runThread = Thread.currentThread();
		stopRequested = false;

		int count = 0;

		while ( !stopRequested ) {
			System.out.println("Running ... count=" + count);
			count++;

			try {
				Thread.sleep(300);
			} catch ( InterruptedException x ) {
				// 自己再调用终止方法；
				Thread.currentThread().interrupt(); // re-assert interrupt
			}
		}
	}

	public void stopRequest() {
		stopRequested = true;

		if ( runThread != null ) {
			runThread.interrupt();
		}
	}

	public static void main(String[] args) {
		AlternateStop as = new AlternateStop();
		Thread t = new Thread(as);
		t.start();

		try {
			Thread.sleep(2000);
		} catch ( InterruptedException x ) {
			// ignore
		}

		as.stopRequest();
	}
}
