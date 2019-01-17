package jvm.chapter3;

/**
 *
 * @version 2018/2/9.
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
//        testAllocation();
//        testPretenureSizeThrehold();
        testTenuringThreshold();
    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *
     *
     [GC (Allocation Failure) [DefNew: 7784K->631K(9216K), 0.0031818 secs] 7784K->6775K(19456K), 0.0032193 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     Heap
     def new generation   total 9216K, used 4864K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff022410, 0x00000000ff400000)
     from space 1024K,  61% used [0x00000000ff500000, 0x00000000ff59dfb8, 0x00000000ff600000)
     to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     tenured generation   total 10240K, used 6144K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     the space 10240K,  60% used [0x00000000ff600000, 0x00000000ffc00030, 0x00000000ffc00200, 0x0000000100000000)
     Metaspace       used 3037K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 332K, capacity 386K, committed 512K, reserved 1048576K
    
     * 内存布局：
     * ------------------------------------------------------------------
     *     eden                 |from | to |          old               |
     * ------------------------------------------------------------------
     *       8M                  1M    1M            10M
    
     a1 = new byte[2 * _1MB];  // 进入 Eden
     a2 = new byte[2 * _1MB]; // 进入 Eden
     a3 = new byte[2 * _1MB];  // 进入 Eden
     a4 = new byte[4 * _1MB];  // 年轻代需要GC， Minor GC，之前的6MB进入 old，a4分配到Eden。
    
    
     *
     *
     *
     *****************************************************************************************
     *
     * (2)不指定使用Serial Collector的情况： PS + Parallel Old
     Heap
     PSYoungGen      total 9216K, used 7959K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     eden space 8192K, 97% used [0x00000000ff600000,0x00000000ffdc5eb8,0x00000000ffe00000)
     from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
     Metaspace       used 3173K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 348K, capacity 386K, committed 512K, reserved 1048576K
     *
     * 怎么解释？？？
     **/
    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];

    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3M
     *
     Heap
     def new generation   total 9216K, used 1804K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     eden space 8192K,  22% used [0x00000000fec00000, 0x00000000fedc31e8, 0x00000000ff400000)
     from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
     tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)   // 直接在老年代
     the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
     Metaspace       used 3171K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 348K, capacity 386K, committed 512K, reserved 1048576K
    
     */
    public static void testPretenureSizeThrehold() {
        byte[] a = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     *
     [GC (Allocation Failure) [DefNew
     Desired survivor size 524288 bytes, new threshold 1 (max 1)
     - age   1:     924384 bytes,     924384 total
     : 5992K->902K(9216K), 0.0026823 secs] 5992K->4998K(19456K), 0.0027163 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Allocation Failure) [DefNew
     Desired survivor size 524288 bytes, new threshold 1 (max 1)
     : 4998K->0K(9216K), 0.0008802 secs] 9094K->4985K(19456K), 0.0008998 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     Heap
     def new generation   total 9216K, used 4150K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     eden space 8192K,  50% used [0x00000000fec00000, 0x00000000ff00dbf8, 0x00000000ff400000)
     from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000) //
     to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
     tenured generation   total 10240K, used 4985K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     the space 10240K,  48% used [0x00000000ff600000, 0x00000000ffade510, 0x00000000ffade600, 0x0000000100000000) //
     Metaspace       used 3173K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 348K, capacity 386K, committed 512K, reserved 1048576K

     *******************************************************************************************
     * -XX:MaxTenuringThreshold=15 的情况
     *
     [GC (Allocation Failure) [DefNew
     Desired survivor size 524288 bytes, new threshold 1 (max 15)
     - age   1:     909656 bytes,     909656 total
     : 5992K->888K(9216K), 0.0028132 secs] 5992K->4984K(19456K), 0.0028437 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Allocation Failure) [DefNew
     Desired survivor size 524288 bytes, new threshold 15 (max 15)
     : 4984K->0K(9216K), 0.0008209 secs] 9080K->4984K(19456K), 0.0008353 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     Heap
     def new generation   total 9216K, used 4150K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     eden space 8192K,  50% used [0x00000000fec00000, 0x00000000ff00dbf8, 0x00000000ff400000)
     from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
     tenured generation   total 10240K, used 4984K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     the space 10240K,  48% used [0x00000000ff600000, 0x00000000ffade168, 0x00000000ffade200, 0x0000000100000000)
     Metaspace       used 3005K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 330K, capacity 386K, committed 512K, reserved 1048576K

     * 结果并非如书中所说（P96）
     */
    public static void testTenuringThreshold() {
        byte[] a1, a2, a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        a3 = new byte[4 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];
    }
}
