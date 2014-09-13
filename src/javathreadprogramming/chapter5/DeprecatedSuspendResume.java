package javathreadprogramming.chapter5;

/**
 * 这个实例说明在不完整的状态的时候如果被中断或恢复，会发生不一致的问题。
 * @author vonzhou
 *
 */
public class DeprecatedSuspendResume extends Object implements Runnable {

	private volatile int firstVal;
	private volatile int secondVal;

	public boolean areValuesEqual() {
		return ( firstVal == secondVal );
	}

	public void run() {
		try {
			firstVal = 0;
			secondVal = 0;
			workMethod();
		} catch ( InterruptedException x ) {
			System.out.println(
					"interrupted while in workMethod()");
		}
	}

	private void workMethod() throws InterruptedException {
		int val = 1;

		while ( true ) {
			stepOne(val);
			stepTwo(val);
			val++;

			Thread.sleep(200);  // pause before looping again
		}
	}

	private void stepOne(int newVal) 
			throws InterruptedException {

		firstVal = newVal;
		Thread.sleep(300);  // simulate some other long process
	}

	private void stepTwo(int newVal) {
		secondVal = newVal;
	}

	public static void main(String[] args) {
		DeprecatedSuspendResume dsr = 
				new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();

		// let the other thread get going and run for a while
		try { Thread.sleep(1000); } 
		catch ( InterruptedException x ) { }

		for ( int i = 0; i < 10; i++ ) {
			t.suspend();
			System.out.println("dsr.areValuesEqual()=" + 
								dsr.areValuesEqual());
			t.resume();
			try { 
				// Pause for a random amount of time 
				// between 0 and 2 seconds.
				Thread.sleep( 
						( long ) (Math.random() * 2000.0) );
			} catch ( InterruptedException x ) {
				// ignore
			}
		}

		System.exit(0); // abruptly terminate application
	}
}
