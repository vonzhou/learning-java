package readingbook.javaconcurrencyinpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SychronizedList {
	public static void main(String[] args) {

	List<Integer> safeList = Collections.synchronizedList(new ArrayList<Integer>());
	synchronized (safeList) {
	      Iterator<Integer> i = safeList.iterator(); // Must be in synchronized block
	      while (i.hasNext())
	          System.out.println(i.next());
	}
	  
	  //------------------------
	  Vector<String> v= new Vector<String>();
	  
	  
	  

	}
}
