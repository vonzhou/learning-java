package oj.acmcoder;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n > 0){
			int max = 0;
			int carry = 0;
			for(int i=1; i<=n;  i++){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				carry = carry + b -a ;
				if(carry > max)
					max = carry;
			}
			
			System.out.println(max);
		}
	
	}
}
