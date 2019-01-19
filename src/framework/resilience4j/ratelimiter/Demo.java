package framework.resilience4j.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {
        // For example you want to restrict the calling rate of some method to be not higher than 10 req/ms.
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMillis(1000))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofMillis(25))
                .build();

// Create registry
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);

// Use registry
        RateLimiter rateLimiterWithDefaultConfig = rateLimiterRegistry.rateLimiter("backend");
        RateLimiter rateLimiterWithCustomConfig = rateLimiterRegistry.rateLimiter("backend#2", config);

// Or create RateLimiter directly
        RateLimiter rateLimiter = RateLimiter.of("NASDAQ :-)", config);

        // Decorate your call to BackendService.doSomething()
        CheckedRunnable restrictedCall = RateLimiter
                .decorateCheckedRunnable(rateLimiter, () -> {
                    System.out.println("invoke func");});


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    Try res= Try.run(restrictedCall);
//                    System.out.println(res.isSuccess());
//                }
//            }
//        }).start();

        for(int i=0;i<100;i++){
            Try res= Try.run(restrictedCall);
            System.out.println(res.isSuccess());
        }

        Try.run(() -> Thread.sleep(10000));
//        Try.run(restrictedCall)
//                .andThenTry(restrictedCall)
//                .andThenTry(restrictedCall)
//                .onFailure(throwable -> System.out.println("Wait before call it again :)"));
    }
}
