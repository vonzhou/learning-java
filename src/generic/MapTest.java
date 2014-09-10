package generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String ,String> map=new HashMap<String,String>();
		map.put("a", "hekko");
		map.put("b","hello");
		
		Set<String> set=map.keySet();
		for(Iterator<String> iterator=set.iterator();iterator.hasNext();){
			String key=iterator.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println("----------------------------");
		Set<Map.Entry<String, String>> set2=map.entrySet();
		for(Iterator<Map.Entry<String, String>> iterator=set2.iterator();iterator.hasNext();){
			Map.Entry<String,String> entry=iterator.next();
			String key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
