package readingbook.apressjavacollections.chapter3;

import java.util.Vector;
public class InsertVector {
  public static void main (String args[]) {
    Vector v = new Vector();
    for (int i=0, n=args.length; i<n; i++) {
      v.add(args[i]);
    }
  }
}