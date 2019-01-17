package jvm.ch08execute;

/**
 * P239
 * 局部变量表Slot对GC的影响
 * 
 * [GC (System.gc())  70779K->66256K(251392K), 0.0047007 secs]
 [Full GC (System.gc())  66256K->66181K(251392K), 0.0197711 secs]
 * 
 * 没有回收这64MB
 * @version 2018/2/23.
 */
public class SlotGC1 {
    public static void main(String[] args) {
        byte[] placeholder = new byte[64 * 1024 * 1024]; // 64MB
        System.gc();
    }
}
