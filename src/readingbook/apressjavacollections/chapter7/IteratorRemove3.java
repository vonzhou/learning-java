package readingbook.apressjavacollections.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemove3 {
	public static void main(String[] args) {
		String ss[] = {"1st", "2nd", "3rd", "4th", "5th",
                "1st", "2nd", "3rd", "4th", "5th"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(ss));
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			String s = it.next();
			if(s.equals("3rd"))
				it.remove();  // 这样是OK的
		}
		
		System.out.println(al);
	}

}










