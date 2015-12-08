package oj.acmcoder;

import java.util.Scanner;

public class MaxSum1003 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n > 0){
			for(int i=1; i<=n; i++){
				int N = scanner.nextInt();
				int arr[]  = new int[N];
				for(int j=0; j<N; j++){
					arr[j] = scanner.nextInt();
				}
				
				int[] res = maxSum(arr);
				
				System.out.println("Case " + i +":");
				System.out.println(res[0] + " " + res[1] + " " + res[2]);
				if(i < n) 
					System.out.println();  
			}
		}
	}
	
	private static int[] maxSum(int[] arr) {
		int maxIndex = 0;
		int minIndex = 0;
		int from=0, to =0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int k=0; k<arr.length; k++){
			if(sum + arr[k] >= arr[k]){
				to = k;
				sum = sum + arr[k];
			}else{
				from = k;
				to = k;
				sum = arr[k];
			}
			
			if(sum > max){
				max = sum;
				maxIndex = to;
				minIndex = from;
			}
		}

		return new int[]{max, minIndex+1, maxIndex+1};
	}

	private static int[] maxSumBad(int[] arr) {
		int maxIndex = 0;
		int minIndex = 0;
		int last = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int k=0; k<arr.length; k++){
			sum += arr[k];
			if(sum > max){
				max = sum ;
				maxIndex = k;
				minIndex = last;
			}
			else if(sum < 0){
				sum = 0;
				
				last = k;
//				maxIndex = k;
				System.out.println("sdf");
			}
			
			if(max < arr[arr.length-1]){
				max = arr[arr.length-1];
				maxIndex = minIndex = arr.length -1;
			}
			
			
		}

		return new int[]{max, minIndex+1, maxIndex+1};
	}

}
