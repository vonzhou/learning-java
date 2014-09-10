package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class RandomTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Random random=new Random();
		Map map=new TreeMap();//存储数字及其出现的次数
		List list=new ArrayList();//存储出现次数最多的数字
		for(int i=0;i<50;i++){
			//nextInt(x)产生一个0到x-1的整数
			int r=random.nextInt(41)+10;
			Integer in=(Integer)r;
			if(map.get(in)==null){
				map.put(in, new Integer(1));
			}
			else{
				int value=((Integer)map.get(in)).intValue();
				map.put(in, new Integer(value+1));
			}
		}
		
		//得到出现次数的一个集合，从而使用Collections中静态方法求最大值
		Collection collection=map.values();
		Integer m=(Integer)Collections.max(collection);
		
		Set set=map.entrySet();
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			Map.Entry entry =(Map.Entry)iterator.next();
			Integer key=(Integer)entry.getKey();
			Integer value=(Integer)entry.getValue();
			if(value.intValue()==m.intValue()){
				list.add(key);
			}
			System.out.println(key+":"+value);
		}
		
		System.out.println("出现最多的次数为："+m.intValue()+"  这些数字为：");
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			Integer in=(Integer)iterator.next();
			System.out.println(in.intValue());
		}
//		for(int i=0;i<list.size();i++){
//			Integer in=(Integer)list.get(i);
//			System.out.println(in.intValue());
//		}
		
	}

}
