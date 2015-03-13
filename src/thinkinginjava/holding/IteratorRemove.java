package thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorRemove {
	
	public static void test1(){
		List<String> famous = new ArrayList<String>();
		famous.add("liudehua");
		famous.add("madehua");
		famous.add("liushishi");
		famous.add("tangwei");
		for (String s : famous) {
			if (s.equals("madehua")) {
				famous.remove(s);
			}
		}
	}
	
	public static void test2(){
		List<String> famous = new ArrayList<String>();
		famous.add("liudehua");
		famous.add("madehua");
		famous.add("liushishi");
		famous.add("tangwei");
		
		Iterator<String> iter = famous.iterator();
		while(iter.hasNext()){
			String s = iter.next();
			if (s.equals("madehua")) {
				famous.remove(s);
			}
		}
		
	}
	
	public static void test3(){
		List<String> famous = new ArrayList<String>();
		famous.add("liudehua");
		famous.add("madehua");
		famous.add("liushishi");
		famous.add("tangwei");
		
		Iterator<String> iter = famous.iterator();
		while(iter.hasNext()){
			String s = iter.next();
			if (s.equals("madehua")) {
				iter.remove();
			}
		}
		
	}

	public static void main(String[] args) {
		test3();
	}

}
