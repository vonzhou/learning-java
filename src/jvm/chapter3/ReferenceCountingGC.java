package jvm.chapter3;

/**
 * P62
 * 
 * -XX:+PrintGCDetails
 * 
 * JVM没有使用引用计数法
 * 
 * 输出：
 [GC (System.gc()) [PSYoungGen: 9339K->712K(76288K)] 9339K->720K(251392K), 0.0584977 secs] [Times: user=0.01 sys=0.00, real=0.07 secs] 
 [Full GC (System.gc()) [PSYoungGen: 712K->0K(76288K)] [ParOldGen: 8K->630K(175104K)] 720K->630K(251392K), [Metaspace: 2993K->2993K(1056768K)], 0.0178885 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
 Heap
 PSYoungGen      total 76288K, used 437K [0x000000076b200000, 0x0000000770700000, 0x00000007c0000000)
 eden space 65536K, 0% used [0x000000076b200000,0x000000076b26d518,0x000000076f200000)
 from space 10752K, 0% used [0x000000076f200000,0x000000076f200000,0x000000076fc80000)
 to   space 10752K, 0% used [0x000000076fc80000,0x000000076fc80000,0x0000000770700000)
 ParOldGen       total 175104K, used 630K [0x00000006c1600000, 0x00000006cc100000, 0x000000076b200000)
 object space 175104K, 0% used [0x00000006c1600000,0x00000006c169db28,0x00000006cc100000)
 Metaspace       used 3000K, capacity 4494K, committed 4864K, reserved 1056768K
 class space    used 329K, capacity 386K, committed 512K, reserved 1048576K
 * 
 * 虽然有相互引用，但是还是进行了回收。
 *
 * GC 日志的分析：
 * 开头的GC，Full GC 表示GC的停顿类型
 * PSYoungGen 表示发生的区域及收集器类型
 * [PSYoungGen: 9339K->712K(76288K)] 9339K->720K(251392K)  GC前年轻代使用9339K，GC后占用712K，该区域总容量76288K。GC前java heap占用9339K，GC后720K，java堆总容量251392K。
 *
 * 
 * @version 2018/2/8.
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

}
