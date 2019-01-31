[主页](http://vonzhou.com)  | [读书](https://github.com/vonzhou/readings)  | [知乎](https://www.zhihu.com/people/vonzhou) | [GitHub](https://github.com/vonzhou)
# IntegerCache源码阅读
---

先从一个思考题开始，考虑下面的代码输出是什么？

*例1*：
```java
public static void test1() {
    Integer a = 1; // 等价于 Integer a = valueOf(1)
    Integer b = 1;
    System.out.println(a == b); 

    Integer c = 128;
    Integer d = 128;
    System.out.println(c == d); 

    System.out.println(c.equals(d)); 
}
```

输出：

```
true
false
true
```


把整数常量赋值给整数包装类型，实际上调用了Integer.valueOf方法，通过指令可以看到：

![](IntegerCache.jpg)


```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

初次访问IntegerCache类，会触发其初始化。


```java
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}
```


可以看到在[low, high]范围内的数值会使用Integer缓存对象，否则新生成一个Integer对象，其中low=-128,high默认是127，但是可以通过JVM选项来配置。比如我们设置`-XX:AutoBoxCacheMax=256`后运行例1，输出：

```
true
true
true
```

所以在进行Integer对象相等性比较的时候，不能直接使用 == (比较的是对象的hashcode，只有[low,high]之间的Integer是相同的), 而应该使用equals方法。

```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
```

在进行普通对象和包装类对象的相等性判断时都应注意这一点。