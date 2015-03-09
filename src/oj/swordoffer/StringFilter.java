package oj.swordoffer;

import java.util.Arrays;

public class StringFilter {
	
	public char[]  filterString(char[] s1, char[] s2){
		if(s1 == null || s2 == null || s1.length <= 0 || s2.length <= 0)
			return null;
		
		// hash the s2 
		int R = 256;
		int[] count = new int[R]; // maybe better use bool array
		charCount(s2, count);
		
		// and then reconstruct the s1
		int k = 0;
		for(int i=0; i<s1.length; i++){
			if(!isExist(s1[i], count))
				s1[k++] = s1[i];
		}
		
		//s1 = Arrays.copyOf(s1, k);  // CANNOT WORK , bcs java pass-by-value 
		//s1 = Arrays.copyOfRange(s1, 0, k); // SO does not change original array
		// so just return it
		return Arrays.copyOf(s1, k);
	}
	
	public boolean isExist(char c, int[] count) {
		if(count[c] > 0)
			return true;
		return false;
	}

	public void charCount(char[] str, int[] count){
		if(str == null || str.length <= 0)
			return;
		
		//System.out.println(Arrays.toString(count));
		for(int i=0; i<str.length; i++)
			count[str[i]] ++;
	}
	
	
	public static void main(String[] args) {
		char[] s1 = "We are students.".toCharArray();
		char[] s2 = "aeiou".toCharArray();
		StringFilter sf = new StringFilter();
		
		char[] res = sf.filterString(s1, s2);
		System.out.println(res);
	}

}

/*
 * Java 总是 pass-by-value 的  所以上面根本不会
 * */
