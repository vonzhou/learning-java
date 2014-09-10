package collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(new Integer(-2));
		list.add(new Integer(2));
		list.add(new Integer(0));
		list.add(new Integer(10));
		
		Comparator c=Collections.reverseOrder();
		Collections.sort(list, c);
		
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
		System.out.println("----------------------------");
		Collections.shuffle(list);
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
		System.out.println("Max value:"+Collections.max(list));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
