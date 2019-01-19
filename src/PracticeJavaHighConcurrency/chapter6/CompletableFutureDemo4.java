package PracticeJavaHighConcurrency.chapter6;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo4 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> calc(50))
                .thenCompose((i) -> CompletableFuture.supplyAsync(() -> calc(i)))
                .thenApply((i) -> Integer.toString(i))
                .thenAccept(System.out::println);
        f.get();
    }

    private static int calc(int i) {
        return i / 2;
    }


}
