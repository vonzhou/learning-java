package PracticeJavaHighConcurrency.chapter6;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        new Thread(new AskThread(f)).start();


        // 模拟计算过程
        Thread.sleep(1000);
        f.complete(60);
    }


    static class AskThread implements Runnable {
        CompletableFuture<Integer> cf = null;

        public AskThread(CompletableFuture<Integer> cf) {
            this.cf = cf;
        }

        @Override
        public void run() {
            try {
                System.out.println(cf.get() * cf.get());

            } catch (Exception e) {

            }
        }
    }
}
