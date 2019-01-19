package concurrent;

/**
 * @version 2017/12/19.
 */
public class StopSleep {

    public static class Task1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("doing....");
                    Thread.sleep(10000);
                    System.out.println("done....");
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    break;
                } catch (Exception e) {

                }
            }

        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Task1());
        t.start();
        t.interrupt();

    }
}
