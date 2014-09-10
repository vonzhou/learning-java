package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//遍历Map的第二种方式。
public class HashMapTest3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashMap map=new HashMap();
		map.put("a", "vonzhou");
		map.put("b", "hellpo");
		
		Set set=map.entrySet();
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			Map.Entry entry=(Map.Entry)iterator.next();
			String key=(String)entry.getKey();
			String value=(String)entry.getValue();
			System.out.println(key+":"+value);
		}
	}

}
