package readingbook.apressjavacollections.chapter6;

import java.util.BitSet;

public class BitExample {
 public static void main (String args[]) {
    BitSet set = new BitSet();
    System.out.println(set);
    set.set(0);
    set.set(36);
    set.set(42);
    System.out.println(set);
 }
}