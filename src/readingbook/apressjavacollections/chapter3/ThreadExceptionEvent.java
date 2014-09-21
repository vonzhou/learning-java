package readingbook.apressjavacollections.chapter3;

import java.util.EventObject;
public class ThreadExceptionEvent extends EventObject {
  public ThreadExceptionEvent(ThreadException source) {
    super(source);
  }
  public Runnable getRunnable() {
    ThreadException source = (ThreadException)getSource();
    return (Runnable)source.getRunnable();
  }
}
