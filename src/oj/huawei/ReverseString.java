package oj.huawei;

import java.util.Scanner;

/*
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
输入参数：
inputString：输入的字符串

返回值：
输出转换好的逆序字符串
 */
public class ReverseString {
	
	public static String reverseString(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String args){
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		System.out.println(reverseString(in));
	}

}
