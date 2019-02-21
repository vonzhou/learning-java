[主页](https://github.com/vonzhou/Blog)  | [读书](https://github.com/vonzhou/Blog/blob/master/Contents/Reading/readings.md)  | [知乎](https://www.zhihu.com/people/vonzhou)
---
# JVM垃圾回收总结



## 1. 垃圾回收算法

### Mark-Sweep(标记-清除)算法

### 复制算法

### Mark-Compact(标记-整理)算法

### 分代收集算法


## 2. 垃圾收集器


![](collectors.jpg)


### 新生代


* Serial

* ParNew

ParNew是Serial的多线程版本， 只有 Serial，ParNew能和CMS配合使用。ParNew是使用CMS后的默认新生代收集器，可以使用`-XX:+UseParNewGC`强制指定。

* Parallel Scavenge

Parallel Scavenge收集器，吞吐量优先，通过参数可以控制最大垃圾收集的停顿时间（-XX:MaxGCPauseMills）及直接设置吞吐量大小（-XX:GCTimeRatio）。也可以开启GC自适应调节策略（GC Ergonomics）。

使用`XX:+UseParallelGC`开启，JDK1.4.1引入。PS只能和Serial Old，ParOld搭配使用。


Java 6，7，8 默认的收集器是Parallel GC（PS + Parallel Old），使用`PrintFlagsFinal`可以看到：

```java
$ ./bin/java -XX:+PrintFlagsFinal
bool UseParallelGC                            := true                                {product}
bool UseParallelOldGC                          = true                                {product}
```

### 老年代

* Serial Old

* Parallel Old

Parallel Old收集器是PS的老年代版本，使用多线程和“标记-整理”。

`XX:+UseParallelOldGC`开启后，也会自动设置``XX:+UseParallelGC``，JDK5.0 update 6引入。


* CMS

CMS收集器，以最短回收停顿时间，服务响应速度为目标，采用标记-清除算法。使用`-XX:+UseConcMarkSweepGC`开启。


### G1收集器

JDK7引入的

G1收集器的Region，其他收集器新生代和老年代之间的对象引用，JVM都是使用Remembered Set来避免全堆扫描。

Java 9,10默认的GC Collector是G1.


[Getting Started with the G1 Garbage Collector](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/G1GettingStarted/index.html)


#### ZGC

JDK11引入

要完成的目标是：控制Java的垃圾回收时长在10ms以内，绝对不超过10ms，并且使用了该垃圾回收策略之后，吞吐对比当前Java缺省的垃圾回收策略G1，下降不超过15%



[Java's new Z Garbage Collector (ZGC) is very exciting](https://www.opsian.com/blog/javas-new-zgc-is-very-exciting/)


---

TODO 使用不同的GC算法看GC日志



## 参考

[Our Collectors](https://blogs.oracle.com/jonthecollector/our-collectors)

[Oracle JVM Garbage Collectors Available From JDK 1.7.0_04 And After](http://www.fasterj.com/articles/oraclecollectors1.shtml)