package readingbook.apressjavacollections.chapter8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo2 {
	public static void main(String[] args) {
		String[] dogs = {"Hu", "Hua", "xiaobai", "dingding"};
		Set s = new HashSet(Arrays.asList(dogs));
		
		Iterator it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
