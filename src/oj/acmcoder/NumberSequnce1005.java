package oj.acmcoder;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSequnce1005 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			int N = scanner.nextInt();
			
			if( A == 0 && B== 0 && N == 0)
				break;
			
			// f(i) is 0-6, need a recircle point
			int[] f = new int[50];
			f[1] = 1;
			f[2] = 1;
			f[0] = -1;
			int i=0;
			if(N > 2){
				for(i=3; i<50; i++){
					f[i] = ( A * f[i-1] + B * f[i-2]) % 7;
					if(f[i] == f[2] && f[i-1] == f[1])
						break;
				}
				
				i = i - 2; 
				// 回退到循环点  1 , 1, ............... A, B, 1, 1, .............
				//                                                i->                    
				N = N%i == 0 ? i : N%i; 
			}
			
			System.out.println(f[N]);
//			System.out.println("i = " + f[N]);
//			System.out.println(Arrays.toString(f));
		}
	}
}
