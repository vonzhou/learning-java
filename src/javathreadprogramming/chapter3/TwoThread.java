package javathreadprogramming.chapter3;

public class TwoThread extends Thread {
	private Thread creatorThread;

	/**
	 * 在对象被创建的时候获得父线程，保存为成员变量
	 */
	public TwoThread() {
		// make a note of the thread that constructed me!
		creatorThread = Thread.currentThread();
	}

	public void run() {
		for ( int i = 0; i < 10; i++ ) {
			printMsg();
		}
	}

	public void printMsg() {
		// get a reference to the thread running this
		Thread t = Thread.currentThread();

		if ( t == creatorThread ) {
			System.out.println("Creator thread");
		} else if ( t == this ) {
			System.out.println("New thread");
		} else {
			System.out.println("Mystery thread --unexpected!");
		}
	}

	public static void main(String[] args) {
		TwoThread tt = new TwoThread();
		tt.start();

		for ( int i = 0; i < 10; i++ ) {
			tt.printMsg();
		}
	}
}
