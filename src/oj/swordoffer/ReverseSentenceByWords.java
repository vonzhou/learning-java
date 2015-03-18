package oj.swordoffer;

import java.util.StringTokenizer;

public class ReverseSentenceByWords {
	
	/*
	 * 利用java的util实现起来不难  
	 */
	   public String reverseWords1(String s) {
	        if (s == null || s.length() == 0)
				return "";

			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(s, " ");
			while(st.hasMoreElements()){
				sb.insert(0, st.nextElement()+" ");
			}
			// 去掉最后一个空格
			String result = sb.toString();
	    if(result.length() <= 0)
				return "";
			else return result.substring(0, result.length() - 1);
	    }
	   
	   
	   
	   
	   public static void main(String[] args) {
		
	}

}
