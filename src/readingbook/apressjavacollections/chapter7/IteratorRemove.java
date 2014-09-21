package readingbook.apressjavacollections.chapter7;

import java.util.ArrayList;
import java.util.Arrays;

public class IteratorRemove {
	public static void main(String[] args) {
		String ss[] = {"1st", "2nd", "3rd", "4th", "5th",
                "1st", "2nd", "3rd", "4th", "5th"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(ss));
		
		for(int i = 0; i < al.size(); i++){
			if(al.get(i).equals("3rd"))
				al.remove(i);
		}
		System.out.println(al);
	}

}
