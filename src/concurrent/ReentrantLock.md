# 可重入锁 ReentrantLock 源码阅读

带着问题阅读。

## 1. 可重入是怎么实现的？

AQS中的同步状态变量state，在 `ReentrantLock` 中表示锁被持有的次数，因为锁是独占的，也可以理解为锁定的深度。锁的可重入便是依赖该字段，下面以公平锁中的锁定过程为例说明（非公平锁也是类似的）。

```java
// ReentrantLock.FairSync.java
protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {   // 首次取锁
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) { // 如果等待队列中没有先到的线程，则尝试获取
            setExclusiveOwnerThread(current);   // 成功，设置该锁的持有线程
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {  // 当前线程就是持有锁的线程，则直接增加计数
        int nextc = c + acquires;
        if (nextc < 0)     // int 溢出了， 这里也决定了递归获取锁的深度
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
```

## 2. 公平，非公平锁是怎么实现的？

ReentrantLock 实例化的时候可以配置公平争用策略，公平，非公平对应了 ReentrantLock  内部的两个AQS类：FairSync，NonfairSync。**默认是非公平的。**

```java
public ReentrantLock() {
    sync = new NonfairSync();
}

public ReentrantLock(boolean fair) {
    sync = fair ? new FairSync() : new NonfairSync();
}
```

锁，释放锁过程如下，无论公平还是非公平锁释放过程是一样的。


![](/images/ReentrantLock-Sync.jpg)


二者的区别在于`tryAcquire`的时候逻辑不同。


公平锁在获取锁之前会判断是否有先到的线程在等待该锁（避免饥饿），实现为：

```java
protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) { // 先看是否有等待者
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}

public final boolean hasQueuedPredecessors() {
    // The correctness of this depends on head being initialized
    // before tail and on head.next being accurate if the current
    // thread is first in queue.
    Node t = tail; // Read fields in reverse initialization order
    Node h = head;
    Node s;
    return h != t &&
        ((s = h.next) == null || s.thread != Thread.currentThread());
}
```

而非公平锁直接进行强占。

```java
/**
 * Performs lock.  Try immediate barge（闯入）, backing up to normal
 * acquire on failure.
 */
final void lock() {
    if (compareAndSetState(0, 1))    // 注意这里
        setExclusiveOwnerThread(Thread.currentThread());
    else
        acquire(1);
}

protected final boolean tryAcquire(int acquires) {
    return nonfairTryAcquire(acquires);
}
// tryLock 也会调用这个方法
final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        if (compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
```
