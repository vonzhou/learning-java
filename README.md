
[主页](https://github.com/vonzhou/Blog)  | [读书](https://github.com/vonzhou/readings)  | [知乎](https://www.zhihu.com/people/vonzhou) 
---
# On The Road Learning Java


## :point_right: 目录

* [Books](#books-books)
* [Java 语言](#coffee-java语言)
* [JVM](#hotsprings-jvm)
* [Framework](#purple_heart-framework)

## :books: Books

* [《深入理解Java虚拟机》](src/jvm/) :+1::+1:
* [《Java并发编程实践》](https://github.com/vonzhou/JavaConcurrencyInPractice) :+1::+1:
* [《Java编程思想》](https://github.com/vonzhou/Thinking-In-Java) :+1::+1:
* [《实战Java高并发程序设计》](src/PracticeJavaHighConcurrency) :+1:
* [《Java8实战》](https://github.com/vonzhou/Java8InAction) :+1:
* [《深入剖析Tomcat》](https://github.com/vonzhou/HowTomcatWorks) :+1::+1:
* [《分布式Java应用 基础与实践》](src/readingbook/分布式Java应用.md) :+1:
* [《大型网站系统与Java中间件实践》](src/readingbook/大型网站系统与Java中间件实践.md) :+1:
* [《Effective Java》](src/effectivejava/)
* [《Java Thread Programming》](src/javathreadprogramming)
* 《RocketMQ实战与原理解析》
* 《Kafka权威指南》 :+1:
* [《Spring MVC学习指南》](https://github.com/vonzhou/SpringMVCTutorial)
* [standalone java examples](https://github.com/vonzhou/java-examples)
* [<Algorithms, 4e> Robert Sedgewick](http://algs4.cs.princeton.edu/home/);

## :coffee: Java语言

* [为什么枚举是实现单例最好的方式？](https://github.com/vonzhou/learning-java/blob/master/src/lang/enumsingleton/Enum.md)  2019.2.14
* [CAS 的底层实现](http://vonzhou.com/cas.html)
* [记一次 ArrayList 线程安全问题](http://vonzhou.com/arraylist-thread-safe-case.html)
* [如何保证ArrayList在多线程环境下的线程安全性](http://vonzhou.com/arraylist-thread-safe.html)
* [synchronized的实现原理](TODO)
* [深入理解条件变量Condition](src/concurrent/深入理解条件变量Condition.md)
* [Hashtable 和 HashMap 的对比](src/collection/HashtableVsHashMap.md)
* [ArrayBlockingQueue与Disruptor的性能对比](http://vonzhou.com/queue-vs-disruptor.html)
* [使用NIO实现的HTTP Server](https://github.com/vonzhou/java-nio-server)


### JDK源码阅读 :rose:

* [TimSort算法](src/collection/TimSort源码分析.md)
* [ConcurrentHashMap源码阅读](src/collection/ConcurrentHashMap.md)
* [可重入锁 ReentrantLock 源码阅读](src/concurrent/ReentrantLock.md)
* [IntegerCache源码阅读](src/lang/IntegerCache.md)
* [Collections工具类源码阅读](src/collection/Collections.md)
* [ThreadLocal](src/lang/ThreadLocal.md)
* [ArrayList](src/collection/ArrayList.md)


## :hotsprings: JVM

* [JVM GC 总结](https://github.com/vonzhou/learning-java/blob/master/src/javavirtualmachine/gc/GC.md) 2019.2.21
* [openjdk7源码阅读](https://github.com/vonzhou/openjdk7-note)

### 我觉得不错的资源

:+1::+1: [JVM Internals](http://blog.jamesdbloom.com/JVMInternals.html)

:+1::+1: [Java (JVM) Memory Model – Memory Management in Java](https://www.journaldev.com/2856/java-jvm-memory-model-memory-management-in-java)

[What is a Java Safepoint?](http://chriskirk.blogspot.com/2013/09/what-is-java-safepoint.html)

[Understanding Garbage Collection](https://www.slideshare.net/dougqh/understanding-garbage-collection)

[The Black Magic of (Java) Method Dispatch](https://shipilev.net/blog/2015/black-magic-method-dispatch/)

[The infamous sun.misc.Unsafe explained](http://mydailyjava.blogspot.com/2013/12/the-infamous-sunmiscunsafe-explained.html)

:+1: [The "Double-Checked Locking is Broken" Declaration](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.htmld)

:+1: [Useful JVM flags, revisited](http://www.javamonamour.org/2015/09/useful-jvm-flags-revisited.html)

[The most complete list of -XX options for Java JVM](http://stas-blogspot.blogspot.com/2011/07/most-complete-list-of-xx-options-for.html)

[The Java Memory Model](http://www.cs.umd.edu/~pugh/java/memoryModel/)


## :purple_heart: Framework

### Disruptor

* [Disruptor 快速入门](http://vonzhou.com/disruptor-hello.html)
* [Disruptor中的事件消费模式](http://vonzhou.com/disruptor-consume-pattern.html)


### Spring 系列

* [DispatcherServlet 源码阅读](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/DispatcherServlet.md)
* [bean解析过程分析](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/bean%E8%A7%A3%E6%9E%90%E5%88%9D%E4%BD%93%E9%AA%8C.md), [bean实例化过程分析](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/bean%E5%AE%9E%E4%BE%8B%E5%8C%96%E6%B5%85%E6%9E%90.md)
* [Spring Boot 执行初始化逻辑的方法](http://vonzhou.com/spring-boot-init-methods.html)
* [如何加快 Spring Boot 项目的启动速度？](http://vonzhou.com/spring-boot-speedup.html)
* [解决Zuul无法同时转发Multipart和JSON请求的问题](http://vonzhou.com/zuul-forward-multipart-and-json.html)


### Dubbo

### Sentinel

### MyBatis

### Tomcat

### RocketMQ

[RocketMQ源码阅读](https://github.com/vonzhou/rocketmq)

### Kafka

[大面积offset commit失败，导致不停Rebalance，大量消息重复消费的问题](src/framework/kafka/rebalancejitter/README.md)

## Algorithm

[Leetcode](src/oj/leetcode)


## Related

[Scala编程之路](https://github.com/vonzhou/learning-scala)
