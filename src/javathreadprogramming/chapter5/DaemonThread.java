package javathreadprogramming.chapter5;

public class DaemonThread extends Object implements Runnable {
	public void run() {
		System.out.println("entering run()");

		try {
			System.out.println("in run() - currentThread()=" + 
					Thread.currentThread());

			while ( true ) {
				try { Thread.sleep(500); } 
				catch ( InterruptedException x ) {}

				System.out.println("in run() - woke up again");
			}
		} finally {
			System.out.println("leaving run()");
		}
	}
}
