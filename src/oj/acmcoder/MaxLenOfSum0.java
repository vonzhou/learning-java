package oj.acmcoder;


import java.util.Arrays;
import java.util.Scanner;

public class MaxLenOfSum0 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		String ss[] = str.split("\\s+");
		
		int[] A = new int[ss.length];
		for(int i=0; i<A.length; i++)
			A[i] = Integer.parseInt(ss[i]);
		
		maxLen(A);
	}
	
	public static void maxLen(int A[]){
		if(A == null || A.length <= 0)
			return ;
		
		int[] B = new int[A.length + 1];
		B[0] = 0;
		
		for(int i=1; i<B.length; i++)
			B[i] = B[i-1] + A[i-1];
		
		
		int res = 0; // max length to i 
		int start = 0, to = 0;
		for(int i=0;i<A.length;i++){
			int t = firstSum2K(B, i, B[i+1]);
			int len = 0;
			//System.out.println("find :" + t);
			if(t != -1)
				len = i - t + 1;
			else len = 0;
			
			if(len > res){
				res = len;
				start = t;
				to = i;
			}
		}
		
		for(int i=start; i<= to; i++){
			if(i == to)
				System.out.println(A[i]);
			else System.out.print(A[i] + " ");
		}
		
	}

	public static int firstSum2K(int[] B, int to , int k) {
		for(int i=0; i<=to; i++)
			if(B[i] == k)
				return i;
		
		return -1;
	}

	

}
