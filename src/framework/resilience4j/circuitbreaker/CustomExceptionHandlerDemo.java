package framework.resilience4j.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;

import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;

import static io.vavr.API.*;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class CustomExceptionHandlerDemo {
    public static void main(String[] args) {
        // Given
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)
                .ringBufferSizeInHalfOpenState(2)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .recordFailure(throwable -> Match(throwable).of(
                        Case($(io.vavr.Predicates.instanceOf(WebServiceException.class)), true),
                        Case($(), false)))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("testName", circuitBreakerConfig);

// Simulate a failure attempt
        circuitBreaker.onError(0, new WebServiceException());
// CircuitBreaker is still CLOSED, because 1 failure is allowed
        System.out.println((circuitBreaker.getState()) == CircuitBreaker.State.CLOSED);

//When
        CheckedRunnable checkedRunnable = CircuitBreaker.decorateCheckedRunnable(circuitBreaker, () -> {
            throw new SocketTimeoutException("BAM!");
        });
        Try result = Try.run(checkedRunnable);

//Then
        System.out.println(result.isFailure());
// CircuitBreaker is still CLOSED, because SocketTimeoutException has not been recorded as a failure
        System.out.println((circuitBreaker.getState()) == CircuitBreaker.State.CLOSED);
        System.out.println(result.failed().get() instanceof IOException);
    }
}
