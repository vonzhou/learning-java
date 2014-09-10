package basic.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		//
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Producer p3 = new Producer(queue);
		Consumer c = new Consumer(queue);

		//
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(p1);
		exec.execute(p2);
		exec.execute(p3);
		exec.execute(c);

		// 让上面的线程执行10s
		Thread.sleep(10 * 1000);
		p1.stop();
		p2.stop();
		p3.stop();

		// 等待消费者2s
		Thread.sleep(2000);

		exec.shutdown();
	}

}
