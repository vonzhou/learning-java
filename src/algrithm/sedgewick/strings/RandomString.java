package algrithm.sedgewick.strings;

import algrithm.sedgewick.fundamental.programmodel.StdRandom;


/**
 * 10. Random string. 
 * Write a recursive function to create a random string of characters between 'A' and 'Z'.
 */
public class RandomString {
	// N代表字符串的長度
	public static String random(int N) {
		   if (N == 0) 
			   return "";
		   // 随机生成一个字符形式的字符串
		   if (N == 1) 
			   return String.valueOf((char)('A' + StdRandom.uniform(26)));
		   // 递归
		   return random(N/2) + random(N - N/2);
	}
	
	public static void main(String[] args) {
		System.out.println(random(1));
		System.out.println(random(10));
	}
	
}
