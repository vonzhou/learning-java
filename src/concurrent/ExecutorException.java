package concurrent;

import java.util.concurrent.*;

/**
 * @author vonzhou
 * @date 2018/12/4
 */
public class ExecutorException {
    static ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(1000), new ThreadFactory() {
        private int counter = 0;
        private String prefix = "Worker";

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, prefix + "-" + counter++);
        }
    }, new RejectedExecutionHandler() {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    public static void main(String[] args) {
        try {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    process();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private static void process() {
        throw new RuntimeException("fake error");
    }
}
