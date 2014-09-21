package readingbook.apressjavacollections.chapter6;
import java.util.BitSet;

public class BitOps {
 public static void main (String args[]) {
    BitSet set = new BitSet();
    set.set(1);
    set.set(2);
    set.set(3);
    set.set(4);
    set.set(5);
    System.out.println(set);
    BitSet set2 = new BitSet();
    set2.set(1);
    set2.set(3);
    set2.set(5);
    set2.set(7);
    BitSet set3 = (BitSet)set.clone();
    set3.and(set2);
    System.out.println(set3);
    set3 = (BitSet)set.clone();
    set3.or(set2);
    System.out.println(set3);
    set3 = (BitSet)set.clone();
    set3.xor(set2);
    System.out.println(set3);
    set3 = (BitSet)set.clone();
    set3.andNot(set2);
    System.out.println(set3);
    set3.andNot(null);
 }
}