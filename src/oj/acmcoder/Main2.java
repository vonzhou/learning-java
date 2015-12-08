package oj.acmcoder;


import java.util.Scanner;

public class Main2 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		for(int i=0; i<T; i++){
			String str = s.nextLine();
			int res = count(str);
			System.out.println(res);
		}
	}

	private static int count(String str) {
		if(str == null || str.isEmpty())
			return 0;
		
		int[] counter = new int[4];
		for (int i = 0; i < 4; i++) {
			counter[i] = 0;
		}
		for(int i=0; i<str.length(); i++){
			if (str.charAt(i) == '9') {
				counter[0]++;
			} else if(str.charAt(i) == '7') {
				if (counter[1] < counter[0]) {
					counter[1]++;
				}
			} else if(str.charAt(i) == '0') {
				if (counter[2] < counter[1]) {
					counter[2]++;
				}
			} else if(str.charAt(i) == '6') {
				if (counter[3] < counter[2]) {
					counter[3]++;
				}
			} else {
				continue;
			}
		}
		
		return counter[3];
	}

}
