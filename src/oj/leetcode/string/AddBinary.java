package oj.leetcode.string;

/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100"
 * 1. 很自然的想到用Plus One中的思路，用一个数组代表不同的位,空间开销是不是太大？
 * 2. 直接用StringBuilder构造,这里假设输入的是合法的
 * 
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a == null)
			a="";
		if(b == null)
			b = "";
		if(a.equals("") || b.equals("") )
			return a + b;
		
		int lena = a.length();
		int lenb = b.length();
		int i = lena -1, j = lenb -1;
		int carry = 0; 
		StringBuilder res = new StringBuilder();
		// 从后往前推进
		while(i >= 0 && j >= 0){
			int inta = a.charAt(i) - '0';
			int intb = b.charAt(j) - '0';
			int sum = inta + intb + carry;
			if(sum >= 2){
				res.insert(0, sum-2);
				carry = 1;
			}else{
				res.insert(0, sum);
				carry = 0;
			}
			
			i--;
			j--;
		}
		
		while(i >= 0){
			int inta = a.charAt(i) - '0';
			int sum = inta + carry;
			if(sum >= 2){
				res.insert(0, sum-2);
				carry = 1;
			}else{
				res.insert(0, sum);
				carry = 0;
			}
			
			i--;
		}
		while(j >= 0){
			int intb = b.charAt(j) - '0';
			int sum = intb + carry;
			if(sum >= 2){
				res.insert(0, sum-2);
				carry = 1;
			}else{
				res.insert(0, sum);
				carry = 0;
			}
			
			j--;
		}
		// 第一次提交错在这里  非0 的话才插入进位值，否则的话  出现" 00"
		if(carry == 1)
			res.insert(0, carry);
		
		return res.toString();
	}
	public static void main(String[] args) {
		String s = null;
		String t = "safas";
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("0", "0"));
	}
}
