package framework.disruptor.threadpoolvsdisruptor.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import framework.disruptor.event.LogEvent;
import framework.disruptor.threadpoolvsdisruptor.Config;
import framework.disruptor.threadpoolvsdisruptor.MsgParser;

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
        MsgParser.parse(event.getMsg());
        if (Config.processed.incrementAndGet() == Config.MSG_COUNT) {
            Config.stopped = true;
        }
    }

    @Override
    public void onEvent(LogEvent event) throws Exception {
        process(event);
    }
}
