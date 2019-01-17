package jvm.ch08execute;

/**
 *
 [GC (System.gc())  70779K->66288K(251392K), 0.0009428 secs]
 [Full GC (System.gc())  66288K->645K(251392K), 0.0134524 secs]
 * 
 * 有回收这64MB
 * @version 2018/2/23.
 */
public class SlotGC3 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024]; // 64MB
        }
        int a = 0;
        System.gc();
    }
}
