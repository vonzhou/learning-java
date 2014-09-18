package readingbook.javaconcurrencyinpractice.vonzhou;


public class NoPublishDemo {
    boolean stop = false;
	//volatile boolean stop = false;

    public static void main(String[] args) {
        // LoadMaker.makeLoad();

        NoPublishDemo demo = new NoPublishDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        // 让新新线程运行一会
        Utils.sleep(1000);
        System.out.println("Set stop to true in main!");
        demo.stop = true;
        System.out.println("Exit main.");
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask started!");
            // 如果主线中stop的值可见，则循环会退出。
            // 简单安全的解法：在running属性上加上volatile）
            // 我的运行总是可以退出的。没有出现问题。
            while (!stop) {
            }
            System.out.println("ConcurrencyCheckTask stopped!");
        }
    }
}
/**
 * 结果是：
 * ConcurrencyCheckTask started!
Set stop to true in main!
Exit main.
ConcurrencyCheckTask stopped!
 * */
