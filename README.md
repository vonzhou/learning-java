
# On The Road Learning Java
---


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
* [Play LeetCode](src/oj/leetcode/)
* [standalone java examples](https://github.com/vonzhou/java-examples)
* Java Thread Programming
* Effective Java
* [<Algorithms, 4e> Robert Sedgewick](http://algs4.cs.princeton.edu/home/);

## :coffee: Java语言

### :zero: Basics

* [IntegerCache源码阅读](src/lang/IntegerCache.md)

### :one: 并发

* [CAS 的底层实现](http://vonzhou.com/cas.html)
* [记一次 ArrayList 线程安全问题](http://vonzhou.com/arraylist-thread-safe-case.html)
* [如何保证ArrayList在多线程环境下的线程安全性](http://vonzhou.com/arraylist-thread-safe.html)
* [synchronized的实现原理](TODO)
* [可重入锁 ReentrantLock 源码阅读](src/concurrent/ReentrantLock.md)
* [深入理解条件变量Condition](src/concurrent/深入理解条件变量Condition.md)

### :two: Collections

* [Hashtable 和 HashMap 的对比](src/collection/HashtableVsHashMap.md)
* [ConcurrentHashMap源码阅读](src/collection/ConcurrentHashMap.md)
* [ArrayBlockingQueue与Disruptor的性能对比](http://vonzhou.com/queue-vs-disruptor.html)
* [TimSort算法](src/collection/TimSort源码分析.md)


### :three: [常用工具类](src/util)

## :hotsprings: JVM

* [openjdk7源码阅读](https://github.com/vonzhou/openjdk7-note)

### 我觉得不错的资源

:+1::+1: [JVM Internals](http://blog.jamesdbloom.com/JVMInternals.html)

:+1::+1: [Java (JVM) Memory Model – Memory Management in Java](https://www.journaldev.com/2856/java-jvm-memory-model-memory-management-in-java)

[What is a Java Safepoint?](http://chriskirk.blogspot.com/2013/09/what-is-java-safepoint.html)

[Understanding Garbage Collection](https://www.slideshare.net/dougqh/understanding-garbage-collection)

[The Black Magic of (Java) Method Dispatch](https://shipilev.net/blog/2015/black-magic-method-dispatch/)

[The infamous sun.misc.Unsafe explained](http://mydailyjava.blogspot.com/2013/12/the-infamous-sunmiscunsafe-explained.html)

:+1: [The "Double-Checked Locking is Broken" Declaration](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.htmld)



## :purple_heart: Framework

### :one: Disruptor

* [Disruptor 快速入门](http://vonzhou.com/disruptor-hello.html)
* [Disruptor中的事件消费模式](http://vonzhou.com/disruptor-consume-pattern.html)


### :two: Spring 系列

* [DispatcherServlet 源码阅读](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/DispatcherServlet.md)
* [bean解析过程分析](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/bean%E8%A7%A3%E6%9E%90%E5%88%9D%E4%BD%93%E9%AA%8C.md), [bean实例化过程分析](https://github.com/vonzhou/learning-spring/blob/master/sourcereading/bean%E5%AE%9E%E4%BE%8B%E5%8C%96%E6%B5%85%E6%9E%90.md)
* [Spring Boot 执行初始化逻辑的方法](http://vonzhou.com/spring-boot-init-methods.html)
* [如何加快 Spring Boot 项目的启动速度？](http://vonzhou.com/spring-boot-speedup.html)
* [解决Zuul无法同时转发Multipart和JSON请求的问题](http://vonzhou.com/zuul-forward-multipart-and-json.html)


