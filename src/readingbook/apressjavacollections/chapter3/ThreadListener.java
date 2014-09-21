package readingbook.apressjavacollections.chapter3;

import java.util.EventListener;
public interface ThreadListener extends EventListener {
  public void exceptionHappened(ThreadException e);
}