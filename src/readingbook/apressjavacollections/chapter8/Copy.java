package readingbook.apressjavacollections.chapter8;

import java.io.*;
import java.util.*;
public class Copy {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    Set set = new HashSet(Arrays.asList(elements));
    Set set2 = ((Set)((HashSet)set).clone());
   
    System.out.println(set2);
    
    System.out.println(set2.remove("Pug"));
    //虽然是浅拷贝，但是移除的仅仅是自己的那份
    System.out.println(set);
    System.out.println(set2);
    
  
    // 但是如何试图修改底层的数据结构呢？
  }
}