package framework.disruptor.threadpoolvsdisruptor.disruptor;

import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import framework.disruptor.event.LogEvent;
import framework.disruptor.threadpoolvsdisruptor.Config;
import framework.disruptor.threadpoolvsdisruptor.MsgGenerator;

import java.util.concurrent.ThreadFactory;

/**
 * @author vonzhou
 * @version 2018/9/21
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        // 环形数组的容量，必须要是2的次幂
        int bufferSize = 1024;

        // 构造 Disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<>(new LogEventFactory(), bufferSize, new ThreadFactory() {
            private int counter = 0;
            private String prefix = "DisruptorWorker";

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, prefix + "-" + counter++);
                t.setDaemon(true);
                return t;
            }
        }, ProducerType.SINGLE, new YieldingWaitStrategy());

        // 设置消费者
        WorkHandler<LogEvent>[] consumers = new LogEventConsumer[Config.WORKER_NUM];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new LogEventConsumer();
        }
        disruptor.handleEventsWithWorkerPool(consumers);

        // 启动 Disruptor
        disruptor.start();

        // 生产者要使用 Disruptor 的环形数组
        LogEventProducer producer = new LogEventProducer(disruptor.getRingBuffer());

        // 模拟消息发送
        for (int i = 0; i < Config.MSG_COUNT; i++) {
            producer.onData(MsgGenerator.get(i));
        }

        while (!Config.stopped) {
        }
        System.out.println(String.format("使用Disruptor(%s X Consumer)处理%s条消息耗时%s ms", Config.WORKER_NUM, Config.MSG_COUNT, (System.currentTimeMillis() - start)));
    }
}
