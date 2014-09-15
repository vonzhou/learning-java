package javathreadprogramming.chapter5;

public class DaemonThreadMain extends Object {
	public static void main(String[] args) {
		System.out.println("entering main()");

		Thread t = new Thread(new DaemonThread());
		t.setDaemon(true);// 设置为守护进程
		t.start();

		try { Thread.sleep(3000); } catch ( InterruptedException x ) { }

		System.out.println("leaving main()");
	}
}
