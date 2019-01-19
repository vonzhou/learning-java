package framework.disruptor.threadpoolvsdisruptor.threadpool;



import framework.disruptor.threadpoolvsdisruptor.Config;
import framework.disruptor.threadpoolvsdisruptor.MsgParser;

import java.util.concurrent.*;

/**
 * @author vonzhou
 * @version 2018/10/8
 */
public class MsgExecutor {

    ExecutorService executor = new ThreadPoolExecutor(Config.WORKER_NUM, Config.WORKER_NUM, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(1024), new ThreadFactory() {
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


    public void process(String data) {
        try {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    parse(data);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse(String data) {
        MsgParser.parse(data);
        if (Config.processed.incrementAndGet() == Config.MSG_COUNT) {
            Config.stopped = true;
        }
    }

}
