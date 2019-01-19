package framework.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import framework.disruptor.event.LogEvent;

/**
 * @author vonzhou
 * @version 2018/9/21
 */
public class LogEventFactory implements EventFactory<LogEvent> {
    @Override
    public LogEvent newInstance() {
        return new LogEvent();
    }
}
