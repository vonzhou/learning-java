package oj.acmcoder;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			printNarcissus(a,b);
			//System.out.println();
		}
	}

	private static void printNarcissus(int a, int b) {
		if(a > 99 && b < 1000 && b > 99 && b <1000 && a <= b){
			int count = 0;
			for(int i=a; i<=b; i++){
				if(isNarcissus(i)){
					count ++;
					System.out.print(i + " ");
				}
					
			}
			if(count == 0) System.out.print("no");
			System.out.println();
		}
		
	}

	private static boolean isNarcissus(int n) {
		int tmp = n;
		int sum = 0;
		while(n>0){
			int x = n % 10;
			sum = sum + x * x * x;
			n /= 10;
		}
		return sum == tmp;
	}

}
