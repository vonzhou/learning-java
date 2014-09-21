package readingbook.apressjavacollections.chapter7;

import java.util.*;
public class FailExample {
  public static void main (String args[]) {
	  String[] ss = {"lasjf","hello","hivonzhou","Hi vonzhou","Hi luy"};
    List list = Arrays.asList(ss);
//    List list = new ArrayList(Arrays.asList(args));
    Iterator i = list.iterator();
    while (i.hasNext()) {
      System.out.println(i.next());
      // 下面这行抛出 java.lang.UnsupportedOperationException
      list.add("Add");
    }
  }
}