package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashMap map=new HashMap();
		map.put("a","hello");
		map.put("b","vonzhou");
		map.put("c","hi");
		map.put("d","welcome");
		map.put("e","bye");
		
		Set set=map.keySet();
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			String key=(String )iterator.next();
			String value=(String)map.get(key);
			System.out.println(key+"="+value);
		}
		
	}
}
