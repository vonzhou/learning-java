package oj.acmcoder;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int c = scanner.nextInt();
		
		if(n > 0){
			int a[] = new int[n];
			for(int i=0; i<n; i++){
				a[i] = scanner.nextInt();
			}
			// n * log(n)
			int count = 0;
			if(n >= c){
				for(int i=0; i<(n-c+1); i++)
					count += doLinear(a, i, t, c);
			}
			
			
			System.out.println(count);
		}
	
	}

	private static int doLinear(int[] a, int i, int t, int c) {
//		int left = i, right=j;
//		int mid = 0;
//		while(left <= right){
//			mid = left + (right-left)/2;
//			if()
//		}
		int max = 0;
		int count = 0;
		for(int k=0;k<c;k++){
			max += a[k+i];
		}
		
		if(max <= t)
			return 1;
		
		return 0;
	}
	
	
}
