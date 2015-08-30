package oj.huawei;
import java.util.Scanner;


public class DeleteDuplicateChar {
	
	public static String deleteDup(String input){
		int index = input.indexOf(',');
		if(index < 0)
			System.out.println("");
		
		int len = Integer.parseInt(input.substring(0, index));
		input = input.substring(index+1, index+len+1);
//		System.out.println(input);
//		StringBuilder sb = new StringBuilder();
		char str[] = new char[len];
		int k = 0;
		int i=0;
		while(i<len){
			if(i == 0){
				str[k] = input.charAt(i);
				k++;
				i++;
			}
			else if(input.charAt(i) == str[k-1])
				i++;
			else str[k++] = input.charAt(i++);
		}
//		System.out.println(Arrays.toString(str));
		String s = new String(str);
		
		return s.substring(0,k);
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(deleteDup(input));
	}

}
