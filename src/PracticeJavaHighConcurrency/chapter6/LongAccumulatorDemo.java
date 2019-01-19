package PracticeJavaHighConcurrency.chapter6;

import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Created by vonzhou on 2019/1/19.
 */
public class LongAccumulatorDemo {
    public static void main(String[] args) throws Exception {
        LongAccumulator accumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);
        Thread[] ts = new Thread[1000];

        for (int i = 0; i < 1000; i++) {
            ts[i] = new Thread(() -> {
                Random r = new Random();
                long val = r.nextLong();
                accumulator.accumulate(val);
            });
            ts[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            ts[i].join();
        }

        System.out.println(accumulator.longValue());
    }
}
