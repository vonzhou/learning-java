package oj.acmcoder;


import java.util.Scanner;

public class Main1 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=0; i<T; i++){
			String str = s.nextLine();
			
			int res = count(str, 0,0,0,0);
			
			System.out.println(res);
		}
	}

	private static int count(String str, int a, int b, int c ,int d) {
		if(str == null || str.isEmpty())
			return 0;
		
		int nine=a,seven=b,zero=c,six=d;
		
		for(int i=nine; i<str.length(); i++){
			if(str.charAt(i) != '9')
				nine ++;
		}
		for(int i=seven; i<str.length(); i++){
			if(str.charAt(i) != '7')
				seven ++;
		}
		for(int i=zero; i<str.length(); i++){
			if(str.charAt(i) != '0')
				zero ++;
		}
		for(int i=six; i<str.length(); i++){
			if(str.charAt(i) != '6')
				six ++;
		}
		System.out.println("sss:" + six);
		
		if(seven > nine && zero > seven && six > zero)
			return 1 + count(str, nine+1, seven+1, zero+1, six+1);
		
		return 0;
	}

}
