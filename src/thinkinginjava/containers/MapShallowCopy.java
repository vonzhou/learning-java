package thinkinginjava.containers;

import java.util.HashMap;
import java.util.Map;


public class MapShallowCopy {
	public static void main(String[] args) {
		 Map<String, String> m = new HashMap<String, String>();
		m.put("Hubei", "wuhan");
		m.put("Shanxi", "xian");
		
		Map<String, String> sc = new HashMap<String, String>(m);
		System.out.println(sc.replace("Hubei", "AAAA"));
		
		for(String key: m.keySet()){
			System.out.println("City= " + key + " capital= " +  m.get(key) );
		}
		
		for(String key: sc.keySet()){
			System.out.println("City= " + key + " capital= " +  sc.get(key) );
		}
		
	}

}
