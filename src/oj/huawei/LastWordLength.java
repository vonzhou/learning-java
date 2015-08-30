package oj.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class LastWordLength{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int res = -1;
		String s = scan.nextLine();
//		System.out.println(s);
		
		s = s.trim();
//		System.out.println(s);
		
		String words[] = s.split("\\s+");
//		System.out.println(Arrays.toString(words));
		if(words != null && words.length > 0){
			res =  words[words.length-1].length();
		}
		
		System.out.println(res);
	}
}

/*
 * http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
 */