package framework.resilience4j.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.vavr.control.Try;

import java.time.Duration;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class Demo {
    public static void main(String[] args) {
        // Given
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("testName", circuitBreakerConfig);

        // Simulate a failure attempt
        circuitBreaker.onError(0, new RuntimeException());
        // CircuitBreaker is still CLOSED, because 1 failure is allowed
        System.out.println((circuitBreaker.getState()) == (CircuitBreaker.State.CLOSED));

        // Simulate a failure attempt
        circuitBreaker.onError(0, new RuntimeException());

        // CircuitBreaker is OPEN, because the failure rate is above 50%
        System.out.println((circuitBreaker.getState()) == CircuitBreaker.State.OPEN);

        // When I decorate my function and invoke the decorated function
        Try<String> result = Try.of(CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "Hello"))
                .map(value -> value + " world");

            // Then the call fails, because CircuitBreaker is OPEN
        System.out.println(result.isFailure());
        // Exception is CircuitBreakerOpenException
        System.out.println(result.failed().get() instanceof CircuitBreakerOpenException);


        circuitBreaker.reset();
        System.out.println(circuitBreaker.getState() == CircuitBreaker.State.CLOSED);





    }
}
