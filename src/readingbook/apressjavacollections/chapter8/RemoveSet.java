package readingbook.apressjavacollections.chapter8;

import java.util.*;
public class RemoveSet {
  public static void main (String args[]) {
    String orig[] = {"Irish Setter", "Poodle", 
       "English Setter", "Gordon Setter", "Pug"};
    String act[]  = {"Poodle", "Pug", "Samoyed"};
    Set origSet = new HashSet(Arrays.asList(orig));
    List actList  = Arrays.asList(act);

    System.out.println(origSet.removeAll(actList));
//    System.out.println(origSet.retainAll(actList));
    System.out.println(origSet);
  }
}