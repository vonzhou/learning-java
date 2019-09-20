# CAS 的底层实现
---

`java.util.concurrent` 包的很多类（如 `Semaphore`，`ConcurrentLinkedQueue`）都提供了比 `sychronized` 机制更高的性能和可伸缩性，源于JDK 1.5提供的原子变量（如`AtomicInteger`,`AtomicReference`），这些原子变量类可以构建高效的非阻塞算法，底层实现是CAS。


CAS（compare and swap）是一种高效实现线程安全性的方法，支持原子更新操作，适用于实现计数器，序列发生器等场景，比如在线程池新增worker线程的时候，需要增加计数，因为i++并非一个原子操作，所以可以使用 `AtomicInteger` 实现安全加1的操作。

```java
// java.util.concurrent.ThreadPoolExecutor
/**
 * Attempts to CAS-increment the workerCount field of ctl.
 */
private boolean compareAndIncrementWorkerCount(int expect) {
    return ctl.compareAndSet(expect, expect + 1);
}
```

CAS和传统的加锁方式（sychronized, ReentrantLock等）相比，CAS是一种乐观方式（对比数据库的悲观、乐观锁），无锁（lock-free），争用失败的线程不会被阻塞挂起，CAS失败时由我们决定是继续尝试，还是执行其他操作。当然这里的无锁只是上层我们感知的无锁，其实底层仍然是有加锁行为的，后面会看到。

此外，CAS存在ABA问题，可以看下 `AtomicStampedReference` ，内部封装的是[reference, integer]。


接下来跟踪下源码。


## CAS底层实现


从 AtomicInteger 入手，其中的属性 valueOffset 是该对象的 value 在内存中的起始地址。

```java
public final boolean compareAndSet(int expect, int update) {
    return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
}

// setup to use Unsafe.compareAndSwapInt for updates
private static final Unsafe unsafe = Unsafe.getUnsafe();
private static final long valueOffset;

static {
    try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
    } catch (Exception ex) { throw new Error(ex); }
}

 private volatile int value;
```

JDK中CAS的API都封装在 `sun.misc.Unsafe` 这个类中。接下来进入 openjdk 中对应的方法，位置 `hotspot\src\share\vm\prims\unsafe.cpp`。

```java
UNSAFE_ENTRY(jboolean, Unsafe_CompareAndSwapInt(JNIEnv *env, jobject unsafe, jobject obj, jlong offset, jint e, jint x))
  UnsafeWrapper("Unsafe_CompareAndSwapInt");
    // 从偏移 obj 得到int的地址 addr
  oop p = JNIHandles::resolve(obj);
  jint* addr = (jint *) index_oop_from_field_offset_long(p, offset);
  return (jint)(Atomic::cmpxchg(x, addr, e)) == e;
UNSAFE_END
```


然后继续 `hotspot\src\share\vm\runtime\atomic.cpp`。

```c
jbyte Atomic::cmpxchg(jbyte exchange_value, volatile jbyte* dest, jbyte compare_value) {
  assert(sizeof(jbyte) == 1, "assumption.");
  uintptr_t dest_addr = (uintptr_t)dest;
  uintptr_t offset = dest_addr % sizeof(jint);
  volatile jint* dest_int = (volatile jint*)(dest_addr - offset);
  jint cur = *dest_int;
  jbyte* cur_as_bytes = (jbyte*)(&cur);
  jint new_val = cur;
  jbyte* new_val_as_bytes = (jbyte*)(&new_val);
  new_val_as_bytes[offset] = exchange_value;
  // 直到更新成功
  while (cur_as_bytes[offset] == compare_value) {
	// 进入
    jint res = cmpxchg(new_val, dest_int, cur);
    if (res == cur) break;
    cur = res;
    new_val = cur;
    new_val_as_bytes[offset] = exchange_value;
  }
  return cur_as_bytes[offset];
}
```

如果是Linux x86架构的话，底层实现是 `hotspot\src\os_cpu\linux_x86\vm\atomic_linux_x86.inline.hpp`：

```c
// Adding a lock prefix to an instruction on MP machine
#define LOCK_IF_MP(mp) "cmp $0, " #mp "; je 1f; lock; 1: "

inline jint     Atomic::cmpxchg    (jint     exchange_value, volatile jint*     dest, jint     compare_value) {
  int mp = os::is_MP();
  __asm__ volatile (LOCK_IF_MP(%4) "cmpxchgl %1,(%3)"
                    : "=a" (exchange_value)
                    : "r" (exchange_value), "a" (compare_value), "r" (dest), "r" (mp)
                    : "cc", "memory");
  return exchange_value;
}
```


x86中对应的机器指令是 CMPXCHG ，如果是多处理器架构的话会有 LOCK 前缀。

## 参考 

* 《Java并发编程实战》

* [compare and swap](https://en.wikipedia.org/wiki/Compare-and-swap)

* [x86 LOCK 指令](https://stackoverflow.com/questions/8891067/what-does-the-lock-instruction-mean-in-x86-assembly)

