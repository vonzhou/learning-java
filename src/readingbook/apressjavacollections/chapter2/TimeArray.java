package readingbook.apressjavacollections.chapter2;

public class TimeArray {
  public static void main (String args[]) {
    int something = 2;
    long startTime = System.currentTimeMillis();
    for (int i=0, n=Integer.MAX_VALUE; i<n; i++) {
      something = -something;
    }
    long midTime = System.currentTimeMillis();
    for (int i=Integer.MAX_VALUE-1; i>=0; i--) {
      something = -something;
    }
    long endTime = System.currentTimeMillis();

    System.out.println("Increasing Delta: " + (midTime - startTime));
    System.out.println("Decreasing Delta: " + (endTime - midTime));
  }
}







