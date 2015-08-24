package mythought.collections;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableDemo {
	public static void main(String args[]){
		Hashtable<String,String> table = new Hashtable<String,String>();
		//table.put(null, "vonzhou"); // java.lang.NullPointerException
		//table.put("key", null);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(null, "vonzou");
		System.out.println(map.get(null));
		
	}
	

}
