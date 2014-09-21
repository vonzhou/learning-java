package readingbook.apressjavacollections.chapter6;

import java.util.BitSet;

public class BitOHoney {
 public static void main (String args[]) {
    String names[] = {
      "Hershey's Kisses", "Nestle's Crunch", 
      "Snickers", "3 Musketeers", 
      "Milky Way", "Twix", "Mr. Goodbar", 
      "Crunchie", "Godiva", "Charleston Chew", 
      "Cadbury's", "Lindt", "Aero", "Hebert", 
      "Toberlone", "Smarties", "LifeSavers", 
      "Riesen", "Goobers", "Raisenettes", "Nerds", 
      "Tootsie Roll", "Sweet Tarts", "Cotton Candy"};
    BitSet bits = new BitSet();
    for (int i=0, n=names.length; i<n; i++) {
      if ((names[i].length() % 2) == 0) {
        bits.set(i);
      }
    }
    System.out.println(bits);
    System.out.println("Size  : " + bits.size());
    System.out.println("Length: " + bits.length());
    for (int i=0, n=names.length; i<n; i++) {
      if (!bits.get(i)) {
        System.out.println(names[i] + " is odd");
      }
    }
    BitSet bites = new BitSet();
    bites.set(0);
    bites.set(1);
    bites.set(2);
    bites.set(3);
    bites.andNot(bits);///////
    System.out.println(bites);
  }
}




