package oj.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int L = s.nextInt();
		if(L <= 1)
			System.out.println(0);
		
		int A[] = new int[N];
		
		for(int i=0; i<N; i++){
			A[i] = s.nextInt();
		}
		
		Arrays.sort(A);
		int B[] = new int[A.length];
		int pos = 1;
		B[0] = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i] != B[pos])
				B[pos++] = A[i];
		}
		
 		int max = 0;
		for(int i=pos-1; i>0; i--){
			max = Math.max(max, B[i] - B[i-1]);
		}
		
		max = Math.max(max, (B[0]-0) * 2);
		max = Math.max(max, (L - B[pos-1]) * 2);
		
		System.out.println(String.format("%.2f", (float)max/2.0));
	}

}
