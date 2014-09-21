package readingbook.apressjavacollections.chapter3;

import java.io.*;
import java.util.*;

public class SaveVector {
  public static void main (String args[]) throws Exception {
	  
    Vector v = new Vector(Arrays.asList(args));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(v);
    oos.close();
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bais);
    Vector v2 = (Vector)ois.readObject();
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
  }
}






