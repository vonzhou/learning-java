package readingbook.apressjavacollections.chapter3;

import java.util.Vector;
public class FindVector {
  static String members[] = 
    {"Ralph", "Waldo", "Emerson", 
     "Henry", "David", "Thoreau",
     "Walden", "Pond",
     "Thoreau", "Institute"};
  public static void main (String args[]) {
    Vector v = new Vector();
    for (int i=0, n=members.length; i<n; i++) {
      v.add(members[i]);
    }
    System.out.println(v);
    System.out.println("Contains Society?: " + 
      v.contains("Society"));
    System.out.println("Contains Waldo?: " + 
      v.contains("Waldo"));
    System.out.println("Where's Waldo?: " + 
      v.indexOf("Waldo"));
    System.out.println("Where's Thoreau?: " + 
      v.indexOf("Thoreau"));
    System.out.println("Where's Thoreau from end?: " + 
      v.lastIndexOf("Thoreau"));
    int index = 0;
    int length = v.size();
    while ((index < length) && (index >= 0)) {
      index = v.indexOf("Thoreau", index);
      if (index != -1) {
        System.out.println(v.get(index));
        index++;
      }
    }
  }
}