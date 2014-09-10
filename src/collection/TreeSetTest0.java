package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest0 {
	public static void main(String[] args) {
		//°´×ÖµäË³ĞòÄæĞòÊä³ö
		TreeSet set=new TreeSet(new ComparatorImpl());
		set.add("B");
		set.add("A");
		set.add("C");
		set.add("a");
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			String value=(String )iterator.next();
			System.out.println(value);
		}
	}

}

class ComparatorImpl implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1=(String )o1;
		String s2=(String )o2;
		return s2.compareTo(s1);
	}
	
}
