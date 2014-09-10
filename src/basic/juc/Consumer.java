package basic.juc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	private static final int DEFAULT_TIME_SLEEP = 100;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String data = null;
		boolean isRunning = true;
		Random r = new Random();
		System.out.println("starting consumer thread....");
		try {
			while (isRunning) {
				System.out.println("getting data from queue...");
				data = queue.poll(2, TimeUnit.SECONDS);
				if (null != data) {
					System.out.println("Got data: " + data);
					System.out.println("Consuming the data : " + data);
					Thread.sleep(r.nextInt(DEFAULT_TIME_SLEEP));
				} else {
					// no data after 2 seconds, regard as all producers died
					isRunning = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();//
		} finally {
			System.out.println("exit the consumer thread...");
		}

	}

}
