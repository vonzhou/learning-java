


实现是 `sun.nio.ch.FileChannelImpl.map`，三个参数分别是：映射模式，起始位置，映射区域的大小。

接下来调用的`map0`是一个本地方法：

```java
private native long map0(int var1, long var2, long var4) throws IOException;
```