package framework.resilience4j.retry;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

import java.time.Duration;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class Demo {
    public static void main(String[] args) {
        // Create a Retry context with a default global configuration
// (maxAttempts = 3, waitDurationInOpenState = 500[ms])
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .build();
        Retry retry = Retry.of("id", config);

        // Decorate the invocation of the HelloWorldService
        CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry, () -> {
            System.out.println("begin");
            if (true) {
                throw new RuntimeException("fake");
            }
            System.out.println("end");
            return "";
        });

        // When I invoke the function
        Try<String> result = Try.of(retryableSupplier);
        System.out.println(result.isSuccess());

        result = Try.of(retryableSupplier).recover((throwable) -> "Hello world from recovery function");
        System.out.println(result.isSuccess());
    }
}
