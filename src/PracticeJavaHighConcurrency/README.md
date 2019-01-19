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

3.2.2　不要重复发明轮子：JDK对线程池的支持<br>
3.2.3　刨根究底：核心线程池的内部实现<br>
3.2.4　超负载了怎么办：拒绝策略<br>
3.2.5　自定义线程创建：ThreadFactory<br>
3.2.6　我的应用我做主：扩展线程池<br>
3.2.7　合理的选择：优化线程池线程数量<br>
3.2.8　堆栈去哪里了：在线程池中寻找堆栈<br>
3.2.9　分而治之：Fork/Join框架<br>
3.3　不要重复发明轮子：JDK的并发容器<br>
3.3.1　超好用的工具类：并发集合简介<br>
3.3.2　线程安全的HashMap<br>
3.3.3　有关List的线程安全<br>
3.3.4　高效读写的队列：深度剖析ConcurrentLinkedQueue<br>
3.3.5　高效读取：不变模式下的CopyOnWriteArrayList<br>
3.3.6　数据共享通道：BlockingQueue<br>
3.3.7　随机数据结构：跳表（SkipList）<br>


第4章　锁的优化及注意事项<br>
4.1　有助于提高"锁"性能的几点建议<br>
4.1.1　减小锁持有时间<br>
4.1.2　减小锁粒度<br>
4.1.3　读写分离锁来替换独占锁<br>
4.1.4　锁分离<br>
4.1.5　锁粗化<br>
4.2　Java虚拟机对锁优化所做的努力<br>
4.2.1　锁偏向<br>
4.2.2　轻量级锁<br>
4.2.3　自旋锁<br>
4.2.4　锁消除<br>
4.3　人手一支笔：ThreadLocal<br>
4.3.1　ThreadLocal的简单使用<br>
4.3.2　ThreadLocal的实现原理<br>
4.3.3　对性能有何帮助<br>
4.4　无锁<br>
4.4.1　与众不同的并发策略：比较交换（CAS）<br>
4.4.2　无锁的线程安全整数：AtomicInteger<br>
4.4.3　Java中的指针：Unsafe类<br>
4.4.4　无锁的对象引用：AtomicReference<br>
4.4.5　带有时间戳的对象引用：AtomicStampedReference<br>
4.4.6　数组也能无锁：AtomicIntegerArray<br>
4.4.7　让普通变量也享受原子操作：AtomicIntegerFieldUpdater<br>
4.4.8　挑战无锁算法：无锁的Vector实现<br>
4.4.9　让线程之间互相帮助：细看SynchronousQueue的实现<br>
4.5　有关死锁的问题<br>
4.6　参考文献


第5章　并行模式与算法<br>
5.1　探讨单例模式<br>
5.2　不变模式<br>
5.3　生产者-消费者模式<br>
5.4　高性能的生产者-消费者：无锁的实现<br>
5.4.1　无锁的缓存框架：Disruptor<br>
5.4.2　用Disruptor实现生产者-消费者案例<br>
5.4.3　提高消费者的响应时间：选择合适的策略<br>
5.4.4　CPU<br>Cache的优化：解决伪共享问题<br>
5.5　Future模式<br>
5.5.1　Future模式的主要角色<br>
5.5.2　Future模式的简单实现<br>
5.5.3　JDK中的Future模式<br>
5.6　并行流水线<br>
5.7　并行搜索<br>
5.8　并行排序<br>
5.8.1　分离数据相关性：奇偶交换排序<br>
5.8.2　改进的插入排序：希尔排序<br>
5.9　并行算法：矩阵乘法<br>
5.10　准备好了再通知我：网络NIO<br>
5.10.1　基于Socket的服务端的多线程模式<br>
5.10.2　使用NIO进行网络编程<br>
5.10.3　使用NIO来实现客户端<br>
5.11　读完了再通知我：AIO<br>
5.11.1　AIO<br>EchoServer的实现<br>
5.11.2　AIO<br>Echo客户端实现<br>


MultiThreadEchoServer, EchoClient

NioEchoServer


## 6. Java 8与并发

6.6　读写锁的改进：StampedLock<br>
6.6.1　StampedLock使用示例<br>
6.6.2　StampedLock的小陷阱<br>
6.6.3　有关StampedLock的实现思想<br>

* 函数式编程
* CompletableFuture
* LongAdder 及 LongAccumulator 的实现原理


第7章　使用Akka构建高并发程序<br>
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
