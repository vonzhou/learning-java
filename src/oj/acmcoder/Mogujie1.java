package oj.acmcoder;


import java.util.Arrays;
import java.util.Scanner;

public class Mogujie1 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine());
		
		if(N > 0){
			int[] arr = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = s.nextInt();
			}
			
			if(N <= 2){
				System.out.println(0);
				return;
			}
			
			int[] dis = new int[N-1];
			for(int i=0; i<N-1; i++){
				dis[i] = arr[i+1] - arr[i];
			}
			
			//System.out.println(Arrays.toString(dis));
			// delete i, and get min max
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N-1; i++){
				int[] tmp = Arrays.copyOf(dis, N-1);
				if(i+1<N-1){
					tmp[i+1] += tmp[i];
				}
				
				tmp[i] = 0;
				//System.out.println(Arrays.toString(tmp));
				int max = getMax(tmp);
				
				min = Math.min(max, min);
			}
			
			System.out.println(min);
		}
	}

	private static int getMax(int[] dis) {
		int max  =0;
		for(int i=0; i<dis.length; i++){
			max = Math.max(max, dis[i]);
		}
		return max;
	}
}
