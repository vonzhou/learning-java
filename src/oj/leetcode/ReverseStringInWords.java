package oj.leetcode;

import java.util.StringTokenizer;

// no. 1
/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Update (2015-02-12):TODO
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * 
 */
public class ReverseStringInWords {
	
	/*
	 * 1. 利用Java的API，但是细节很多
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";

		// split() 会包含字符串开头空串，而末尾的没有
		String arr[] = s.split(" ");
		if (arr.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals(""))
				sb.append(arr[i]).append(" ");
		}

		// 去掉最后一个空格
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
	}
	
	/*
	 * 2. 那么 StringTokenizer 呢？就不会有开头的空格
	 * "    " 经过 StringTokenizer 得到的是空串"" ，要特别注意
	 */
	public String reverseWords2(String s) {
		if (s == null || s.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(s, " ");
		while(st.hasMoreElements()){
			sb.insert(0, st.nextElement()+" ");
		}
		// 去掉最后一个空格
		String result = sb.toString();
		//System.out.println(result);
		if(result.length() <= 0)
			return "";
		else return result.substring(0, result.length() - 1);
	}
	
	/*
	 * 3. 用C语言如何实现 in-place in O(1) space. ？？？
	 */

	public static void main(String[] args) {
		String s = "   rwerqwe vwrtqw3 c  ";
		String arr[] = s.split(" ");
		for (int i = 0; i < arr.length; i++)
			System.out.println("=" + arr[i] + "=");
		String s2 = " ";
		System.out.println(new ReverseStringInWords().reverseWords2(s2) + "=");
	}
}
