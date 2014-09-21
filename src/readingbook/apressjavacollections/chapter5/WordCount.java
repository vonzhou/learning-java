package readingbook.apressjavacollections.chapter5;

import java.io.*;
import java.util.*;

public class WordCount {
  static final Integer ONE = new Integer(1);

  public static void main (String args[]) throws IOException {

    Hashtable map = new Hashtable();
    String file = "C:\\data\\1.txt";
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line = br.readLine()) != null) {
      processLine(line, map);
    }
    
    Enumeration enumer = map.keys();
    while (enumer.hasMoreElements()) {
      String key = (String)enumer.nextElement();
      System.out.println(key + " : " + map.get(key));
    }
  }
  static void processLine(String line, Map map) {
    StringTokenizer st = new StringTokenizer(line);
    while (st.hasMoreTokens()) {
      addWord(map, st.nextToken());
    }
  }
  static void addWord(Map map, String word) {
    Object obj = map.get(word);
    if (obj == null) {
      map.put(word, ONE);
    } else {
      int i = ((Integer)obj).intValue() + 1;
      map.put(word, new Integer(i));
    }
  }
}

