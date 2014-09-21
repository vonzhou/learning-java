package readingbook.apressjavacollections.chapter2;

public class ArrayArgs {
  public static void main (String args[]) {
    for (int i=0, n=args.length; i<n; i++) {
      System.out.println("Arg " + i + ": " + args[i]);
    }
  }
}