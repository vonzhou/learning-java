# 《实战Java高并发程序设计》


## 2. Java并行程序基础

* 线程的几种状态,切换的条件
* volatile与Java内存模型
* synchronized底层怎么实现的?修饰类和方法的异同

## 3.JDK并发包

* ReentrantLock,及条件变量
* 信号量（Semaphore
* ReadWriteLock读写锁
* CountDownLatch
* LockSupport工具类
* 线程池深入理解:各个参数含义,拒绝策略,线程工厂,任务队列,线程数量
* JKD1.7引入的Fork/Join框架:分而治之,内部一个ForkJoin线程池
* JDK的并发容器:ConcurrentHashMap, ConcurrentLinkedQueue(使用了CAS), CopyOnWriteArrayList, BlockingQueue


## 4.锁的优化及注意事项

* 锁优化的方法:减小锁持有时间,减小锁粒度,读写分离,锁粗化
* JVM所做的努力:偏向锁,轻量级锁,自旋锁,锁消除
* ThreadLocal
* CAS,原子类,AtomicStampedReference,AtomicIntegerArray,AtomicIntegerFieldUpdater
* SynchronousQueue的实现 TODO

## 5. 并行模式与算法

* Singleton
* Immutable
* Producer Consumer模式
* Disruptor
* Future模式
* NIO
* AIO

## 6. Java 8与并发

* 函数式编程
* CompletableFuture
* LongAdder 及 LongAccumulator 的实现原理
* StampedLock,优化了读写锁,内部维护了一个队列


## 7. 使用Akka构建高并发程序

7.1　新并发模型：Actor<br>
7.2　Akka之Hello<br>World<br>
7.3　有关消息投递的一些说明<br>
7.4　Actor的生命周期<br>
7.5　监督策略<br>
7.6　选择Actor<br>
7.7　消息收件箱（Inbox）<br>
7.8　消息路由<br>
7.9　Actor的内置状态转换<br>
7.10　询问模式：Actor中的Future<br>
7.11　多个Actor同时修改数据：Agent<br>
7.12　像数据库一样操作内存数据：软件事务内存<br>
