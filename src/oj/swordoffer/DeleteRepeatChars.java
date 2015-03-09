package oj.swordoffer;

import java.util.Arrays;

public class DeleteRepeatChars {
	
	public static char[] deleteRepeat(char[] str){
		if(str == null || str.length <= 0)
			return null;
		
		int R = 256;
		boolean[] set = new boolean[R];
		int k = 0;
		for(int i=0; i<str.length; i++){
			if(!set[str[i]]){
				str[k] = str[i];
				k++;
				set[str[i]] = true;
			}
				
		}
		
		return Arrays.copyOf(str, k); //str = Arrays.copyOfRange(str, 0, k-2);
	}
	
	public static void main(String[] args) {
		char[] str = "goole".toCharArray();
		char[] res = deleteRepeat(str);
		System.out.println(res);
 	}

}
