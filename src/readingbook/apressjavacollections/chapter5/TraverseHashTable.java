package readingbook.apressjavacollections.chapter5;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class TraverseHashTable {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		for(int i = 0; i <= 10; i++)
			ht.put(i, "value" + i);
		
		Enumeration e  = ht.keys();
		while(e.hasMoreElements()){
			Object o = e.nextElement();
			System.out.println(ht.get(o));
		}
		
		//------------------
		Set entry = ht.entrySet();
		Iterator it = entry.iterator();
		while(it.hasNext()){
			Map.Entry en = (Map.Entry)it.next();
			System.out.println(en.getKey() + "=" + en.getValue());
		}
	}

}
