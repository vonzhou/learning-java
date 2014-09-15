package jenkov.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService =
		        Executors.newScheduledThreadPool(5);

		ScheduledFuture<Object> scheduledFuture =
		    scheduledExecutorService.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		            System.out.println("Executed!");
		            return "Called!";
		        }
		    },
		    5,
		    TimeUnit.SECONDS); // 5 秒后执行
		
		System.out.println("in main ");
		
		try {
			//没有执行完成前，这里会阻塞？？
			System.out.println("result = " + scheduledFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		scheduledExecutorService.shutdown();
	}

}
