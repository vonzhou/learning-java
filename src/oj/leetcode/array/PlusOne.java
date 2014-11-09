package oj.leetcode.array;

import java.util.Arrays;

/*
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * 先加 再处理进位的问题，是否考虑溢出 ？？扩容？？
 * 
 * Input:	[7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
Output:	null
Expected:	[7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7]
 * fuck 尽然无需考虑溢出 
 */
public class PlusOne {
	// 考虑溢出
	public int[] plusOne1(int[] digits) {
		if(digits == null || digits.length == 0)
			return null;
		
		String limit = (Long.MAX_VALUE -1) + "";
		
		String input = arr2Str(digits);
		
		if(input.length() > limit.length())
			return null;
		else if(input.length() == limit.length()){
			// overflow
			if(input.compareTo(limit) >= 0)
				return null;
		}
		
		// 用足够大的空间来运算,Long.MAX_VALUE=9223372036854775807, 20bits就可以
		int tmp[] = new int[20];
		for(int i = 0; i < 20; i++)
			tmp[i] = 0;
		int len = digits.length;
		int j = len;
		for(int i = 19; i >= (20-len); i--){
			tmp[i] = digits[--j];
		}
		
		tmp[19] += 1;
		for(int i = 19; i >= 0; i--){
			if(tmp[i] < 10)
				break;
			else{
				tmp[i] = 10 - tmp[i];
				tmp[i-1] += 1;
			}
		}
		
		int i = 0;
		while(tmp[i] == 0)
			i++;
		
		int res[] = new int[20-i];
		for(int k = i; k < 20; k++)
			res[k-i] = tmp[k];
		
		
		return res;
	}
	
	
	

	// 2. AC
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0)
			return null;
		
		// 用足够大的空间来运算,Long.MAX_VALUE=9223372036854775807, 20bits就可以
		int space = digits.length + 1;
		int tmp[] = new int[space];
		
		tmp[0] = 0;
		
		for(int i = 1; i < space; i++){
			tmp[i] = digits[i-1];
		}
		
		tmp[space-1] += 1;
		for(int i = space-1; i > 0; i--){
			if(tmp[i] < 10)
				break;
			else{
				tmp[i] = 10 - tmp[i];
				tmp[i-1] += 1;
			}
		}
		int res[] = null;
		if(tmp[0] == 0){
			res = new int[space-1];
			for(int i = 0; i< space-1; i++)
				res[i] = tmp[i+1];
		}else{
			res = tmp;
		}
		return res;
	}
	
	public String arr2Str(int[] digits) {
		String res = "";
		for(int i =0; i < digits.length; i++)
			res += digits[i]+"";
		return res;
	}

	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = {9,1};
		showArray(po.plusOne(digits));
		//System.out.println(Long.MAX_VALUE);
	}


	public static void showArray(int[] a) {
		if(a == null)
			return;
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
		System.out.println();
	}
}
