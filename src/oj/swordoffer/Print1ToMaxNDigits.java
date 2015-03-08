package oj.swordoffer;

import java.util.Arrays;

public class Print1ToMaxNDigits {
	
	/* use string to store big integer
	 * 
	 */
	public void print1ToMax(int n){
		if(n <= 0)
			return ;
		char[] numbers = new char[n];
		Arrays.fill(numbers, '0');
		while(!increment(numbers)){
			printNumbers(numbers);
		}
		
	}

	public boolean increment(char[] numbers) {
		boolean overflow = false;
		int carry = 0;
		int len = numbers.length;
		for(int i= len -1; i>=0; i--){
			int sum = numbers[i] - '0' + carry;
			if(i==len-1)
				sum++;
			if(sum >= 10){
				if(i==0)
					overflow = true;
				else{
					sum -= 10;
					carry = 1;
					numbers[i] = (char)(sum + '0');
				}
			}else{
				numbers[i] = (char)(sum + '0');
				break;
			}
		}
		return overflow;
	}

	public void printNumbers(char[] numbers) {
		boolean beginning0 = true;
		int len = numbers.length;
		for(int i=0; i<len; i++){
			if(beginning0 && numbers[i] != '0')
				beginning0 = false;
			if(!beginning0)
				System.out.print(numbers[i]);
		}
		System.out.println();
	}
	
	/* 2 求全排列， 利用递归
	 * 
	 */
	public void print1ToMax2(int n){
		if(n <= 0)
			return ;
		char[] numbers = new char[n];
		for(int i=0; i<10; i++){
			numbers[0] = (char)(i+'0');
			print1ToMaxRecursively(numbers, 0);
		}
	}
	
	public void print1ToMaxRecursively(char[] numbers, int index){
		if(index == numbers.length-1){
			printNumbers(numbers);
			return;
		}
		for(int i=0; i<10; i++){
			numbers[index+1] = (char)(i+'0');
			print1ToMaxRecursively(numbers, index+1);
		}
	} 
	
	public static void main(String[] args) {
		Print1ToMaxNDigits test = new Print1ToMaxNDigits();
		test.print1ToMax2(3);
	}
}
