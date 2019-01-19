package PracticeJavaHighConcurrency.chapter6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * P283
 * 对比加同步锁,原子类,LongAdder实现累加的性能
 * LongAdder并没有表现很好啊
 * Created by vonzhou on 2019/1/19.
 */
public class LongAdderPerf {
    private static final int TARGET_COUNT = 10000000;
    private static final int TASK_COUNT = 3;
    private static final int MAX_THREADS = 3;

    private AtomicLong acount = new AtomicLong(0L);
    private LongAdder longAdder = new LongAdder();


    private static CountDownLatch cdlSync = new CountDownLatch(TASK_COUNT);
    private static CountDownLatch cdlAtomic = new CountDownLatch(TASK_COUNT);
    private static CountDownLatch cdlLongAdder = new CountDownLatch(TASK_COUNT);

    private long count = 0;

    private synchronized long inc() {
        return ++count;
    }

    private synchronized long getCount() {
        return count;
    }

    class SyncThread implements Runnable {
        String name;
        long startTime;
        LongAdderPerf out;

        public SyncThread(LongAdderPerf out, long startTime) {
            this.out = out;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT) {
                v = out.inc();
            }
            long end = System.currentTimeMillis();
            System.out.println("SyncThread cost " + (end - startTime) + "ms, v=" + v);
            cdlSync.countDown();
        }
    }

    public void syncPerf() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(MAX_THREADS);
        long start = System.currentTimeMillis();
        SyncThread s = new SyncThread(this, start);
        for (int i = 0; i < TASK_COUNT; i++) {
            ex.submit(s);
        }
        cdlSync.await();
        ex.shutdown();
    }

    class AtomicThread implements Runnable {
        long startTime;

        public AtomicThread(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long v = acount.get();
            while (v < TARGET_COUNT) {
                v = acount.incrementAndGet();
            }
            long end = System.currentTimeMillis();
            System.out.println("AtomicThread cost " + (end - startTime) + "ms, v=" + v);
            cdlAtomic.countDown();
        }
    }

    public void atomicPerf() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(MAX_THREADS);
        long start = System.currentTimeMillis();
        AtomicThread s = new AtomicThread(start);
        for (int i = 0; i < TASK_COUNT; i++) {
            ex.submit(s);
        }
        cdlAtomic.await();
        ex.shutdown();
    }

    class LongAdderThread implements Runnable {
        long startTime;

        public LongAdderThread(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long v = longAdder.sum();
            while (v < TARGET_COUNT) {
                longAdder.increment();
                v = longAdder.sum();
            }
            long end = System.currentTimeMillis();
            System.out.println("LongAdder cost " + (end - startTime) + "ms, v=" + v);
            cdlLongAdder.countDown();
        }
    }

    public void longAdderPerf() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(MAX_THREADS);
        long start = System.currentTimeMillis();
        LongAdderThread s = new LongAdderThread(start);
        for (int i = 0; i < TASK_COUNT; i++) {
            ex.submit(s);
        }
        cdlLongAdder.await();
        ex.shutdown();
    }

    /*

    SyncThread cost 334ms, v=10000001
    SyncThread cost 335ms, v=10000000
    SyncThread cost 335ms, v=10000002
    AtomicThread cost 160ms, v=10000000
    AtomicThread cost 161ms, v=10000001
    AtomicThread cost 162ms, v=10000002
    LongAdder cost 221ms, v=10000001
    LongAdder cost 221ms, v=10000000
    LongAdder cost 221ms, v=10000001


     */
    public static void main(String[] args) throws Exception {
        new LongAdderPerf().syncPerf();
        new LongAdderPerf().atomicPerf();
        new LongAdderPerf().longAdderPerf();
    }

}
