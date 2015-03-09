package oj.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

public class ConstructMinFromIntArray {
	class MyStringComparator<T> implements Comparator<T>{

		@Override
		public int compare(Object o1, Object o2) {
			String s1 = (String)o1;
			String s2 = (String)o2;
			String comb1 = s1+s2, comb2 = s2+s1;
			return comb1.compareTo(comb2);
		}
		
	}
	
	public void printMinNumber(int[] numbers, int len){
		if(numbers == null || len <= 0)
			return;
		
		String[] strs = new String[len];
		for(int i=0; i<len; i++)
			strs[i] = numbers[i] + "";
		Comparator<String> c = new MyStringComparator<String>();
		Arrays.sort(strs, c);
		
		System.out.println(Arrays.toString(strs));
	}
	
	public static void main(String[] args) {
		ConstructMinFromIntArray test = new ConstructMinFromIntArray();
		int[] a = {3,32, 321};
		test.printMinNumber(a, a.length);
	}

}
