package javathreadprogramming.chapter2;

public class TwoThread extends Thread {
	public void run() {
		for ( int i = 0; i < 10; i++ ) {
			System.out.println("New thread");
		}
	}

	public static void main(String[] args) {
		TwoThread tt = new TwoThread();
		tt.start();

		for ( int i = 0; i < 10; i++ ) {
			System.out.println("Main thread");
		}
	}
}
