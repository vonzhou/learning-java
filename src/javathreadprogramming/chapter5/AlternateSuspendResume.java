package javathreadprogramming.chapter5;

public class AlternateSuspendResume extends Object implements Runnable {

	private volatile int firstVal;
	private volatile int secondVal;
	private volatile boolean suspended;

	public boolean areValuesEqual() {
		return ( firstVal == secondVal );
	}

	public void run() {
		try {
			suspended = false;
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
			// 感觉这里就像加锁解锁，
			// blocks only if suspended is true
			waitWhileSuspended(); 

			stepOne(val);
			stepTwo(val);
			val++;

			// blocks only if suspended is true
			waitWhileSuspended(); 

			Thread.sleep(200);  // pause before looping again
		}
	}

	private void stepOne(int newVal) 
					throws InterruptedException {

		firstVal = newVal;

		// simulate some other lengthy process
		Thread.sleep(300);  
	}

	private void stepTwo(int newVal) {
		secondVal = newVal;
	}

	public void suspendRequest() {
		suspended = true;
	}

	public void resumeRequest() {
		suspended = false;
	}

	// 忙等//////////
	private void waitWhileSuspended() 
				throws InterruptedException {

		// This is an example of a "busy wait" technique.  It is
		// not the best way to wait for a condition to change 
		// because it continually requires some processor 
		// cycles to perform the checks.  A better technique 
		// is to use Java's built-in wait-notify mechanism.
		while ( suspended ) {
			Thread.sleep(200);
		}
	}

	public static void main(String[] args) {
		AlternateSuspendResume asr = 
				new AlternateSuspendResume();

		Thread t = new Thread(asr);
		t.start();

		// let the other thread get going and run for a while
		try { Thread.sleep(1000); } 
		catch ( InterruptedException x ) { }

		for ( int i = 0; i < 10; i++ ) {
			asr.suspendRequest();

			// Give the thread a chance to notice the 
			// suspension request.
			try { Thread.sleep(350); } 
			catch ( InterruptedException x ) { }

			System.out.println("dsr.areValuesEqual()=" + 
					asr.areValuesEqual());

			asr.resumeRequest();

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
