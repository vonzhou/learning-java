package PracticeJavaHighConcurrency.chapter6;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo3 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> calc(50))
                .exceptionally(ex -> {
                    System.out.println(ex);
                    return 0;
                })
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "/" + str + "/")
                .thenAccept(System.out::println);
        f.get();
    }

    private static int calc(int i) {
       return  i/ 0;
    }


}
