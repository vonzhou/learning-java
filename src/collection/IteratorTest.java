package collection;

import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add("vonzhou");
		set.add("hello");
		set.add("welcome");
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			String value=(String)iterator.next();
			System.out.println(value);
		}
	}

}
