package readingbook.apressjavacollections.chapter3;

import java.util.Vector;
public class ExceptionCatcherThread extends ThreadGroup {

  private Runnable runnable;
  private Thread runner;
  private Vector listenerList = new Vector(3);

  /* For autonumbering our group. */
  private static int threadInitNumber;
  private static synchronized int nextThreadNum() {
    return threadInitNumber++;
  }

  public ExceptionCatcherThread(Runnable r) {
    super("ExceptionCatcherThread-" + nextThreadNum());
    runnable = r;
    // Create thread in this group
    runner = new Thread(this, runnable);
  }

  public void start() {
    runner.start();
  }

  /* Listener registration methods */

  public synchronized void addThreadExceptionListener(ThreadListener t) {
    listenerList.add(t);
  }
  public synchronized void removeThreadExceptionListener(ThreadListener t) {
    listenerList.remove(t);
  }

  public void uncaughtException(Thread source, Throwable t) {
    fireExceptionHappened(t);
    super.uncaughtException(source, t);
  }

  protected void fireExceptionHappened(Throwable t) {
    ThreadException e = (t instanceof ThreadException) ?
      (ThreadException)t : new ThreadException(runnable, t);
    Vector l;
    synchronized(this) {
      l = (Vector) listenerList.clone();
    }
    for (int i = 0, n = listenerList.size(); i < n; i++) {
      ThreadListener tl = (ThreadListener) l.get(i);
      tl.exceptionHappened(e);
    }
  }
}