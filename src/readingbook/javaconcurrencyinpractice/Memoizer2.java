package readingbook.javaconcurrencyinpractice;

import java.util.*;
import java.util.concurrent.*;

/**
 * Memoizer2
 * <p/>
 * Replacing HashMap with ConcurrentHashMap
 *
 * @author Brian Goetz and Tim Peierls
 */
public class Memoizer2 <A, V> implements Computable<A, V> {
	// 使用并发容器；
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
        	// 但是这里 “先检查而后操作”，容易出现问题。
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
