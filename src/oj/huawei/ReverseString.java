package oj.huawei;

import java.util.Scanner;

public class ReverseString {
	
	public static String reverseString(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		System.out.println(reverseString(in));
	}

}
