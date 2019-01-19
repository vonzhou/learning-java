package framework.disruptor;

import java.util.concurrent.*;

/**
 * @author vonzhou
 * @version 2018/9/21
 */
public class MultiConsumer2_2 {
    public static final int WORKER_SIZE = 4;

    private static final int MSG_NUM = 500000;

    private static final CountDownLatch countdown = new CountDownLatch(MSG_NUM);

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        // Fixed Thread Pool
        ExecutorService executor = new ThreadPoolExecutor(WORKER_SIZE, WORKER_SIZE, 0L, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(1024), new ThreadFactory() {
                            private int counter = 0;
                            private String prefix = "DisruptorWorker";

                            @Override
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r, prefix + "-" + counter++);
                                t.setDaemon(true);
                                return t;
                            }
                        }, new RejectedExecutionHandler() {

                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                                try {
                                    executor.getQueue().put(r);
                                } catch (InterruptedException e) {
                                    System.out.println("Disrutptor worker 拒绝策略执行异常！" + e);
                                }
                            }
                        });

        // 模拟消息发送
        for (int i = 0; i < MSG_NUM; i++) {
            executor.submit(new Task(String.format("M%s", i)));
        }

        countdown.await();
        System.out.println(String.format("== Total cost %s seconds ==", (System.currentTimeMillis() - start) / 1000));

    }

    public static class Task implements Runnable {
        private String msg;

        public Task(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " | Event : " + msg);
//                Thread.sleep(20);
                countdown.countDown();
            } catch (Exception e) {

            }
        }
    }
}
