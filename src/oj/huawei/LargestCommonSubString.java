package oj.huawei;

import java.util.Scanner;

public class LargestCommonSubString {
	// to lower case ..
	public static char charAt(String s, int i){
		return Character.toLowerCase(s.charAt(i));
	}
	
	public static int getLCSlen(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() <= 0 || s2.length() <= 0)
			return 0;
		// space cost M*N, from index 1
		int m = s1.length();
		int n = s2.length();
		int lens[][] = new int[m+1][n+1]; 
		int largest = 0;
		
		for(int i=0; i<m+1; i++){
			for(int j=0; j < n+1; j++){
				if(i==0 || j==0)
					lens[i][j] = 0;
				else if(charAt(s1,i-1) == charAt(s2,j-1)){
						lens[i][j] = lens[i-1][j-1] + 1;
						if(lens[i][j] > largest)
							largest = lens[i][j];
				}
				else lens[i][j] =0;
				
			}
		}
		
		return largest;
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int i = s.indexOf(' ');
		String s1 = s.substring(0, i);
		String s2 =  s.substring(i+1);
//		System.out.println(s1);
//		System.out.println(s2);
		
		System.out.println(getLCSlen(s1, s2));
	}

}
