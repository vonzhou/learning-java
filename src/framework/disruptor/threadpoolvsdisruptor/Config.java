package framework.disruptor.threadpoolvsdisruptor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vonzhou
 * @date 2018/11/30
 */
public class Config {
    public static final int WORKER_NUM = 4;
    public static final int MSG_COUNT = 10000000;
    public static final long MSG_PROC_TIME = 2;
    public static volatile  boolean stopped = false;
    public static AtomicInteger processed = new AtomicInteger(0);

}
