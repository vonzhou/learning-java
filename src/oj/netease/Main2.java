package oj.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int [] A=new int [N];
		
		for(int i=0;i<N;i++){
			A[i]=scan.nextInt();
		}
		int M=scan.nextInt();
		int []B=new int [M];
		for(int j=0;j<M;j++){
			B[j]=scan.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			int tmp=score(A,B,i);
			if(max<tmp) max=tmp;
		}
		System.out.println(max);
	}
	
	public static int score(int[]a,int []b,int index){
		int count=0;
		for(int i=0;i<b.length;i++){
			if(b[i]<a[index]) count++;
			else break;
		}
		
		return (index-count)*2+(a.length-index-b.length+count)*3;
	}
}
