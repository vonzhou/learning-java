package oj.acmcoder;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			double res = 0.0;
			if(m > 0){
				res = sumSqrt(n, m);
			}
			
			System.out.println(String.format("%.2f", res));
		}
	}

	private static double sumSqrt(int n, int m) {
		double sum = 0.0;
		double np = n ;
		sum = np;
		while(m > 1){
			np = Math.sqrt(np);
			sum += np;
			m -- ;
		}
		return sum;
	}

}
