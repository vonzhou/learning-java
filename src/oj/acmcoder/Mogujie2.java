package oj.acmcoder;

//AC 
import java.util.Scanner;

public class Mogujie2 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
			//System.out.println();
		}
		
		int cur = 0;
		int need = 1;
		for(int i=0; i<n; i++){
			if(cur + arr[i] <= m){
				cur = cur + arr[i];
			}else{
				need ++;
				cur = arr[i];
			}
		}
		
		System.out.println(need);
	}
}
