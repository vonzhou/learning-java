package jenkov.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutorServiceDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		//executing a Runnable with an ExecutorService
		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});
		System.out.println("vonzhou");
		
		Future future = executorService.submit(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task2");
		    }
		});

		try {
			System.out.println("result: " + future.get());
			//returns null if the task has finished correctly.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//利用Callable，它的call方法可以返回值,泛型是返回值的类型
		future = executorService.submit(new Callable<Object>(){
		    public Object call() throws Exception {
		        System.out.println("Asynchronous Callable");
		        return "Callable Result";
		    }
		});

		try {
			System.out.println("future.get() = " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}

}
