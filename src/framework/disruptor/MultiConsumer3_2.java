package framework.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;
import framework.disruptor.consumer.LogEventConsumer;
import framework.disruptor.event.LogEvent;
import framework.disruptor.factory.LogEventFactory;
import framework.disruptor.producer.LogEventProducer;

import java.util.concurrent.*;

/**
 * @author vonzhou
 * @version 2018/9/21
 */
public class MultiConsumer3_2 {
    public static final int WORKER_SIZE = 2;
    public static final int WORKER_SIZE_MAX = 2;

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(WORKER_SIZE, WORKER_SIZE_MAX, 0L, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(1000), new ThreadFactory() {
                            private int counter = 0;
                            private String prefix = "DisruptorWorker";

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
                                    System.out.println("Disrutptor worker 拒绝策略执行异常！" + e);
                                }
                            }
                        });
        // 环形数组的容量，必须要是2的次幂
        int bufferSize = 1024;

        // 设置消费者
        WorkHandler<LogEvent>[] consumers = new LogEventConsumer[4];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new LogEventConsumer();
        }

        // 创建ringBuffer
        RingBuffer<LogEvent> ringBuffer = RingBuffer.create(ProducerType.SINGLE, new LogEventFactory(), bufferSize, new YieldingWaitStrategy());
        SequenceBarrier barriers = ringBuffer.newBarrier();


        WorkerPool<LogEvent> workerPool = new WorkerPool<LogEvent>(ringBuffer, barriers,
                null, consumers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(executor);

        // 生产者要使用 Disruptor 的环形数组
        LogEventProducer producer = new LogEventProducer(ringBuffer);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 模拟消息发送
                for (int i = 0; i < 5000; i++) {
                    String msg = String.format("M%s", i);
                    System.out.println("==== produce " + msg);
                    producer.onData(msg);
                }
                System.exit(0);
            }
        }).start();
    }
}
