package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
//统计命令行中出现的各个字符串的个数，使用Map
public class HashMapTest2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashMap map=new HashMap();
		for(int i=0;i<args.length;i++){
			if(map.get(args[i])==null){
				map.put(args[i], new Integer(1));
			}
			else{
				Integer a=(Integer)map.get(args[i]);
				a=new Integer(a.intValue()+1);
				map.put(args[i],a);
			}
		}
		
		Set set=map.keySet();
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			String key=(String)iterator.next();
			Integer a=(Integer)map.get(key);
			System.out.println(key+":"+a);
		}
		
	}

}
