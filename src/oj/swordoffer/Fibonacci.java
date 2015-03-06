package oj.swordoffer;

public class Fibonacci {
	
	public static long fibonacciRecur(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacciRecur(n-1) + fibonacciRecur(n-2);
	}
	
	// 使用迭代，每一次保存必要的状态信息供下次loop使用
	public static long fibonacciIter(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		long a = 0, b=1;
		long c = 0;
		for(int i=2; i<=n; i++){
			c = a+b;
			b = c;
			a = b;
		}
		
		return c;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(fibonacciRecur(20));
		System.out.println(fibonacciRecur(20));
	}

}
