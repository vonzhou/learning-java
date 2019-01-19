package PracticeJavaHighConcurrency.chapter6;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "/" + str + "/")
                .thenAccept(System.out::println);
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
