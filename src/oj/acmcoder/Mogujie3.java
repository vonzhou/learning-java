package oj.acmcoder;

import java.util.Scanner;

public class Mogujie3 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int r=scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();
		int x1=scan.nextInt();
		int y1=scan.nextInt();
		
		System.out.println(move(r,x,y,x1,y1));
	}
	
	public static int move(int r,int x,int y,int x1,int y1){
		double dis=Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
		
		int res=(int) Math.ceil(dis/(2*r));
		return res;
	}
}
