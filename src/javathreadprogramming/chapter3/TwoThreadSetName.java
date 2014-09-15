package javathreadprogramming.chapter3;
/**
 * 为线程重命名最好遵循这些：
 *  1.Invoke setName() on the Thread before start(), and do not rename the 
 *  Thread after it is started. 
 *  2. Give each thread a brief, meaningful name when possible.   
 *  3. Give each thread a unique name.      
 *  4. Do not change the names of JavaVM threads, such as main. 
 * @author vonzhou
 *
 */
public class TwoThreadSetName extends Thread {
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
		TwoThreadSetName tt = new TwoThreadSetName();
		tt.setName("my worker thread");//
		tt.start();

		for ( int i = 0; i < 10; i++ ) {
			tt.printMsg();
		}
	}
}
