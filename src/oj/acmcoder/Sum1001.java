package oj.acmcoder;

import java.util.Scanner;

public class Sum1001 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
//		List list = new ArrayList();
//		while(scanner.hasNextInt()){
//			int a = scanner.nextInt();
//			list.add(sum(a));
//		}
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
		// n* n+1 may overflow, so divide before multiply
		while(scanner.hasNextInt()){
			int a = scanner.nextInt();
			int res = 0;
			if(a % 2 == 0)
				res = a / 2 * (a+1);
			else res = (a+1)/2 * a;
			
			System.out.println(res);
			System.out.println(); //NB
		}
	}

}
