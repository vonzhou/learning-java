package framework.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import framework.disruptor.event.LogEvent;

/**
 * @author vonzhou
 * @version 2018/9/21
 */
public class LogEventConsumer implements EventHandler<LogEvent>, WorkHandler<LogEvent> {

    @Override
    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {

        process(event);
    }

    private void process(LogEvent event) throws Exception {
        System.out.println(Thread.currentThread().getName() + " | Event : " + event);
        Thread.sleep(20);
    }

    @Override
    public void onEvent(LogEvent event) throws Exception {
        process(event);
    }
}
