package oj.swordoffer;

import java.util.Arrays;


public class StringPermutation {
	
	public void permutation(char[] str){
		if(str == null)
			return;
		permutation(str, 0);
	}

	public void permutation(char[] str, int index) {
		if(index == str.length){
			System.out.println(Arrays.toString(str));
		}else{
			for(int i=index; i<str.length; i++){
				swap(str, index, i);
				permutation(str, index + 1);
				swap(str, index, i);
			}
		}
	}

	public void swap(char[] str, int index, int i) {
		char tmp = str[index];
		str[index] = str[i];
		str[i] = tmp;
	}
	
	/********************************************
	 * 不断递归，通过参数传递当前已经构成的字符串，以及可供的选择
	 */
	public static void RecPermute(String soFar, String rest)
	{
	    if (rest.length()<=0) {
	        System.out.println(soFar);
	    } else {
	        for (int i = 0; i < rest.length(); i++) {
	            String remaining = rest.substring(0, i)
	                             + rest.substring(i+1);
	            RecPermute(soFar + rest.charAt(i), remaining);
	        }
	    }
	}
	
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		sp.permutation(new char[]{'A', 'B', 'C'});
	}

}
