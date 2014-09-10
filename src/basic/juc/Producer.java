package basic.juc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	private volatile boolean isRunning = true;
	private BlockingQueue queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int DEFAULT_SLEEP_TIME = 1000;// 1 second

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String data = null;
		Random r = new Random();
		System.out.println("starting producer thread...");
		try {
			while (isRunning) {
				System.out.println("producing data....");
				Thread.sleep(r.nextInt(DEFAULT_SLEEP_TIME));
				data = "data:" + count.incrementAndGet();
				System.out.println("puting data into the queue....");
				// TRY it
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.err.println("put data to the queue failed..");
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();//
		} finally {
			System.out.println("exit the producer thread...");
		}
	}

	public void stop() {
		isRunning = false;
	}

}
