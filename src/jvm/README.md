# 《深入理解Java虚拟机》:+1::+1::+1::+1:


## 2.JAVA内存模型与OOM

## 3.垃圾收集器与内存分配策略

Serial收集器

ParNew是Serial的多线程版本， 只有 Serial，ParNew能和CMS配置使用。ParNew是使用-XX:+UseConcMarkSweepGC后的默认新生代收集器，可以使用-XX:+UseParNewGC强制指定他。

Parallel Scavenge收集器，吞吐量优先，通过参数可以控制最大垃圾收集的停顿时间（-XX:MaxGCPauseMills）及直接设置吞吐量大小（-XX:GCTimeRatio）。也可以开启GC自适应调节策略（GC Ergonomics）。

Serial Old收集器

Parallel Old收集器是PS的老年代版本，使用多线程和“标记-整理”。

CMS收集器，以最短回收停顿时间，服务响应速度为目标，采用标记-清除算法。

G1收集器。

G1收集器的Region，其他收集器新生代和老年代之间的对象引用，JVM都是使用Remembered Set来避免全堆扫描。


## 6. Class文件结构

[一个简单Class文件的分析](https://zhuanlan.zhihu.com/p/23068093)


## 7.类加载机制

有且只有5种情况会触发类的初始化：

* （1）使用new实例化对象，访问静态类的字段或方法；
* （2）反射调用；
* （3）要初始化类的父类；
* （4）JVM启动时的主类；
* （5）MethodHandle对应是静态方法。

数组类不通过类加载器创建，而是由JVM直接创建，但是数据类的元素类型（Element Type）最终要靠类加载器。如果数组类C的组件类型不是引用类型（如int[]），则标记C与引导类加载器关联。