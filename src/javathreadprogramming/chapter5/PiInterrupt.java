package javathreadprogramming.chapter5;

/**
 * 如果一个方法需要很长时间运算，通常采用这种方法，在一个单独的线程中
 * 捕获它的异常，优雅的处理。
 *
 */
public class PiInterrupt extends Object implements Runnable {
	private double latestPiEstimate;

	public void run() {
		try {
			System.out.println("for comparison, Math.PI=" + 
								Math.PI);
			calcPi(0.000000001);
			System.out.println("within accuracy, latest pi=" + 
								latestPiEstimate);
		} catch ( InterruptedException x ) {
			System.out.println("INTERRUPTED!! latest pi=" + 
								latestPiEstimate);
		}
	}

	private void calcPi(double accuracy) 
				throws InterruptedException {

		latestPiEstimate = 0.0;
		long iteration = 0;
		int sign = -1;

		while ( Math.abs(latestPiEstimate - Math.PI) > 
				accuracy ) {

			if ( Thread.interrupted() ) {
				throw new InterruptedException();
			}

			iteration++;
			sign = -sign;
			latestPiEstimate += 
					sign * 4.0 / ( ( 2 * iteration ) - 1 );
		}
	}

	public static void main(String[] args) {
		PiInterrupt pi = new PiInterrupt();
		Thread t = new Thread(pi);
		t.start();

		try {
			Thread.sleep(10000);
			t.interrupt();
		} catch ( InterruptedException x ) {
			// ignore
		}
	}
}
