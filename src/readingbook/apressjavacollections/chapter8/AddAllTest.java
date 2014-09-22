package readingbook.apressjavacollections.chapter8;

import java.util.*;
public class AddAllTest {
  public static void main (String args[]) {
    Set set = new HashSet();
    Set set2 = new HashSet();
    
    StringBuffer buff1 = new StringBuffer("Irish Setter");
    StringBuffer buff2 = new StringBuffer("Irish Setter");
    set.add(buff1);
    set2.add(buff2);
    System.out.println(set.addAll(set2));
    System.out.println(set.addAll(set));
  }
}