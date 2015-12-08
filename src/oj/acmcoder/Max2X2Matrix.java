package oj.acmcoder;


import java.util.Scanner;

public class Max2X2Matrix {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		
		// get matrix from input
		String[] parse=input.split(";");
		if(parse.length<2) return;

		int [][] matrix=new int[parse.length][parse[0].length()];
		for(int i=0;i<parse.length;i++){
			String [] line=parse[i].trim().split("\\s+");
			for (int j=0;j<line.length;j++){
				matrix[i][j]=Integer.parseInt(line[j]);
			}
		}		
		System.out.println(max2X2(matrix));
	}
	
	public static int max2X2(int [][]matrix){
		int width=matrix[0].length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<matrix.length-1;i++){
			for(int j=0;j<matrix[i].length-1;j++){
				int t=matrix[i][j]+matrix[i+1][j]
						+matrix[i][j+1]+matrix[i+1][j+1];
				if(max<t) max=t;
			}
		}
		return max;
	}
}