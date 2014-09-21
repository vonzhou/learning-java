package readingbook.apressjavacollections.chapter5;

import java.util.*;
import java.io.*;

public class PropertyList {
  public static void main (String args[]) throws Exception {
    Properties p = System.getProperties();
    p.list(System.out);
    FileOutputStream fos = new FileOutputStream("C:\\data\\sys.out");
    p.store(fos, null);
    fos.close();
    Map map = new TreeMap(p);
    System.out.println(map);
  }
}