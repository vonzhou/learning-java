package jvm.ch08execute;

/**
 *
 [GC (System.gc())  70779K->66288K(251392K), 0.0010098 secs]
 [Full GC (System.gc())  66288K->66181K(251392K), 0.0039661 secs]
 * 
 * 仍然没有回收这64MB
 * @version 2018/2/23.
 */
public class SlotGC2 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024]; // 64MB
        }
        System.gc();
    }
}
