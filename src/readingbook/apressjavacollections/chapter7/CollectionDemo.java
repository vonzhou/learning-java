package readingbook.apressjavacollections.chapter7;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("vonzhou");
		c.add("123");
		c.addAll(c);////
		
		System.out.println(c);
		
	}

}
