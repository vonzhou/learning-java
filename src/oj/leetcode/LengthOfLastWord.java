package oj.leetcode;


/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *For example,
 *Given s = "Hello World",
 *return 5.
 *
 *问题：1. 多个空格如何处理？
 *2.开头结尾的空格呢？
 */
public class LengthOfLastWord {  
	public static int lengthOfLastWord(String s){
		if(s == null || s == "")
			return 0;
		String ss[] = s.split(" ");
		// 消除里面的空串，没有必要
		//----
		//System.out.println(ss.length);
		if(ss.length == 0)
			return 0;
		return ss[ss.length-1].length();
	}
	
	public static void main(String[] args) {
		String s = "  ";
		String ss[] = s.split("=");
		for(int i = 0; i< ss.length;i++){
			
			if(ss[i].equals("")) System.out.println("blank"); 
			else System.out.println(ss[i]);
		}
		
		//-------------
		System.out.println(lengthOfLastWord(s));
			
	}

}
