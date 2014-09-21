package readingbook.apressjavacollections.chapter7;

import java.util.*;
public class PredTest {
	// ÄÚ²¿Àà
  static Predicate pred = new Predicate() {
    public boolean predicate(Object o) {
      return o.toString().startsWith("Hi");
    }
  };
  public static void main (String args[]) {
	  String[] ss = {"lasjf","hello","hivonzhou","Hi vonzhou","Hi luy"};
    List list = Arrays.asList(ss);
    Iterator i1 = list.iterator();
    Iterator i = new PredicateIterator(i1, pred);
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }
}



