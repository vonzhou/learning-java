package PracticeJavaHighConcurrency.chapter6;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws Exception {
        // 返回的future作为契约
        CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "/" + str + "/")
                .thenAccept(System.out::println);


        /// 做其他的事情

        // 需要结果的时候
        f.get();
    }

    private static int calc(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * i;
    }


}
