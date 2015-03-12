package thinginjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class StringTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Run";
	}
}



public class TestThreadPool{
	public static void test1(){
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for(int i=0; i<10;i++)
			pool.submit(new StringTask());
		pool.shutdown();
	}
	
	
	public static void test2() throws Exception{
		ExecutorService pool = Executors.newFixedThreadPool(4);

		List<Future<String>> futures = new ArrayList<Future<String>>(10);

		for(int i = 0; i < 10; i++){
		   futures.add(pool.submit(new StringTask()));
		}

		for(Future<String> future : futures){
		   String result = future.get();
		   System.out.println(result);
		   //Compute the result
		}

		pool.shutdown();
	}
	
	public static void test3() throws Exception{
		ExecutorService threadPool = Executors.newFixedThreadPool(4);

		CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);

		for(int i = 0; i < 10; i++){
		   pool.submit(new StringTask());
		}

		for(int i = 0; i < 10; i++){
		   String result = pool.take().get();
		   System.out.println(result);
		   //Compute the result
		}

		threadPool.shutdown();
	}

	public static void main(String[] args) throws Exception {
		
		test3();
	}

}
