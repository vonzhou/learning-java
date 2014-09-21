package readingbook.apressjavacollections.chapter3;

import java.util.Vector;
public class PrimVector {
  public static void main (String args[]) {
    Vector v = new Vector();
    for (int i=1; i<=10; i++) {
      v.add(new Integer(i));
    }
    System.out.println(v);
  }
}