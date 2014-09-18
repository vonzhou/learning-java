package readingbook.javaconcurrencyinpractice;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.*;

/**
 * LogService
 * <p/>
 * Adding reliable cancellation to LogWriter
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;
    
    private boolean isShutdown = false;
    private int reservations = 0;

    public LogService(Writer writer) {
    	
        this.queue = new LinkedBlockingQueue<String>();
        this.loggerThread = new LoggerThread();
        this.writer = new PrintWriter(writer);
    }

    public void start() {
        loggerThread.start();
    }

    public void stop() {
    	// 设置关闭标识
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
        	//如果设置，则不能往里面加入新的消息
            if (isShutdown)
                throw new IllegalStateException(/*...*/);
            
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0)
                                break;
                        }
                        String msg = queue.take();
                        // 每消费一个消息，就递减计数
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) { /* retry */
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}

