package javathreadprogramming.chapter3;

public class TwoThreadGetName extends Thread {
	public void run() {
		for ( int i = 0; i < 10; i++ ) {
			printMsg();
		}
	}

	public void printMsg() {
		// get a reference to the thread running this
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("name=" + name);
	}

	public static void main(String[] args) {
		TwoThreadGetName tt = new TwoThreadGetName();
		tt.start();

		for ( int i = 0; i < 10; i++ ) {
			tt.printMsg();
		}
	}
}
