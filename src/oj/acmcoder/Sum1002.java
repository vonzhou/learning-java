package oj.acmcoder;

import java.math.BigInteger;
import java.util.Scanner;

public class Sum1002 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n > 0){
			for(int i=1; i<=n; i++){
				BigInteger a = scanner.nextBigInteger();
				BigInteger b = scanner.nextBigInteger();
				System.out.println("Case " + i +":");
				System.out.println(a + " + " + b + " = " + a.add(b));
				if(i < n) 
					System.out.println();  //NB. Last result has no '\n'
			}
		}
	}

}
