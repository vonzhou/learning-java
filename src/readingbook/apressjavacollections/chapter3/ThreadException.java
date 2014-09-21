package readingbook.apressjavacollections.chapter3;

public class ThreadException extends RuntimeException {
  Runnable runnable;
  Throwable exception;
  public ThreadException(Runnable r, Throwable t) {
    runnable = r;
    exception = t;
  }
  public ThreadException(Runnable r, Throwable t, String message) {
    super(message);
    runnable = r;
    exception = t;
  }
  public Runnable getRunnable() {
    return runnable;
  }
  public Throwable getSourceException() {
    return exception;
  }
}