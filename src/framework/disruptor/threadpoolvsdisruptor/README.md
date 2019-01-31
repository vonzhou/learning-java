[主页](http://vonzhou.com)  | [读书](https://github.com/vonzhou/readings)  | [知乎](https://www.zhihu.com/people/vonzhou) | [GitHub](https://github.com/vonzhou)
---
# ArrayBlockingQueue与Disruptor的性能对比
---

虽然Disruptor采用了lock-free的算法，但并非银弹，本文以最常用的场景来测试ArrayBlockingQueue和Disruptor的作为缓存队列的性能优劣。

## 测试环境

* 消息大小 20B
* Windows 10, 4内核，8逻辑CPU
* JDK 8

## 测试用例

 本文采用一个生产者来生产特定数量的消息，然后使用缓冲队列，由特定数量的消费者来共同消费处理这批消息。

每条消息处理耗时20ms的情况 ， 4消费线程：


| 方式| 1K| 1W|10W|
|---|---|---|---|
|ABQ|5s|52s|525s|
|Disruptor|5s|52s|529s|


每条消息处理耗时20ms的情况 ， 8消费线程：

| 方式| 1K| 1W|10W|
|---|---|---|---|
|ABQ|2s|26s|263s|
|Disruptor|2s|26s|263s|


从中可以看到，平均下来5ms一条消息（每条消息耗时20ms，4个线程）。如果一条消息处理的时间比较长，则使用普通ABQ，Disruptor开销差别不大，因为大头时间在消息的处理上，锁争用的开销不明显。


每条消息处理耗时20ms的情况 ， 4消费线程：


| 方式| 1K| 1W|10W|
|---|---|---|---|
|ABQ|756ms|7.332s|72.73s|
|Disruptor|826ms|7.279s|71.047s|


每条消息处理耗时2ms的情况 ， 1消费线程：

| 方式| 1K| 1W|10W|100W|
|---|---|---|---|---|
|ABQ|3.156s|28.803s|284.221s|2846 s|
|Disruptor|3.063s|28.436s|284.158s|2812 s|


当消息处理很快时（< 1ms）。


1消费线程：

| 方式| 1K| 1W|10W|100W|1000W|1W * 1W|
|---|---|---|---|---|---|---|
|ABQ|37ms|151ms|1059ms|8.59s|87 s|813 s|
|Disruptor|94ms|215ms|7.6s|7.6s|69.87 s|684 s|

4消费线程：

| 方式| 1K| 1W|10W|100W|1000W|1W * 1W|
|---|---|---|---|---|---|---|
|ABQ|38ms|181ms|1243ms|9.74s|100s|1024 s|
|Disruptor|63ms|162ms| 1167ms |9.88s |97.8s|1002 s|


## 总结

从上面的测试情况下，处理在消息处理很快，且使用单消费者的时候Disruptor表现较好，其他情况并没有任何优势。

在Disruptor官方文档中给出的性能测试结果并没有涵盖本文中的场景，官方文档中的1P-3C多播方式要用多个ArrayBlockingQueue来实现Disruptor中的Multicast方式（内部是一个RingBuffer，但是多个Sequnce）。

所以在选用Disruptor的时候一定要具体的测试，搞清自己的场景，像本文中的一个生产者，多个消费者共同处理消息的场景使用普通的线程池+ABQ就足够了，并不比Disruptor表现差。

