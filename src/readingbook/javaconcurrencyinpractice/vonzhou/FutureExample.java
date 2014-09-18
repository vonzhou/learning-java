package readingbook.javaconcurrencyinpractice.vonzhou;

import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureExample {
    public static void main(String[] args) throws Exception {
	System.out.println("Using fixed thread pool:");
	ExecutorService executor = Executors.newFixedThreadPool(2);
	test(executor);

	System.out.println("\nUsing cached thread pool:");
	executor = Executors.newCachedThreadPool();
	test(executor);

	System.out.println("\nUsing single thread executor:");
	executor = Executors.newSingleThreadExecutor();
	test(executor);
    }

    private static void test(ExecutorService executor) 
		   throws ExecutionException, InterruptedException {
	Counter counter = new Counter();

	Future<?> f1 = executor.submit(new Worker(counter, true, 10000));
	Future<?> f2 = executor.submit(new Worker(counter, false, 10000));

	// reject new tasks, must call in order to exit VM
	executor.shutdown();

	// wait for termination, much like Thread.join()
	f1.get();
	f2.get();

	System.out.println("Final count: " + counter.getCount());
    }
}

class Counter {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
	c.getAndIncrement();
    }

    public void decrement() {
	c.getAndDecrement();
    }

    public int getCount() {
	return c.get();
    }
}

class Worker implements Runnable {
    private Counter counter;
    private boolean increment;
    private int count;

    public Worker(Counter counter, boolean increment, int count) {
	this.counter = counter;
	this.increment = increment;
	this.count = count;
    }

    public void run() {
	for (int i = 0; i < this.count; i++) {
	    if (increment) {
		this.counter.increment();
	    }
	    else {
		this.counter.decrement();
	    }
	}
    }
}
