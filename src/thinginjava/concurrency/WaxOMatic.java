// Basic task cooperation.
package thinginjava.concurrency;

import java.util.concurrent.*;
import static thinkinginjava.util.Print.*;

class Car {
	private boolean waxOn = false;

	public synchronized void waxed() {
		waxOn = true; // Ready to buff
		notifyAll();
	}

	public synchronized void buffed() {
		waxOn = false; // Ready for another coat of wax
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false)
			wait();
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn == true)
			wait();
	}
}

class WaxOn implements Runnable {
	private CarII car;

	public WaxOn(CarII c) {
		car = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				printnb("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			print("Exiting via interrupt");
		}
		print("Ending Wax On task");
	}
}

class WaxOff implements Runnable {
	private CarII car;

	public WaxOff(CarII c) {
		car = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				printnb("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			print("Exiting via interrupt");
		}
		print("Ending Wax Off task");
	}
}

public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		CarII car = new CarII();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5); // Run for a while...
		exec.shutdownNow(); // Interrupt all tasks
	}
} 
