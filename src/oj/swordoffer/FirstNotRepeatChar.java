package oj.swordoffer;

import java.util.Arrays;

public class FirstNotRepeatChar {
	
	public static char firstChar(char[] str){
		if(str == null || str.length <= 0)
			return ' ';
		int R = 256;
		int[] count = new int[R];
		//System.out.println(Arrays.toString(count));
		for(int i=0; i<str.length; i++)
			count[str[i]] ++;
		System.out.println(Arrays.toString(count));
		for(int i=0; i<str.length; i++)
			if(count[str[i]] == 1)
			return str[i];
		
		return ' ';
	}
	
	public static void main(String[] args) {
		System.out.println(firstChar("abaccdeff".toCharArray()));
		
	}

}
