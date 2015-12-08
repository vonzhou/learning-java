package oj.acmcoder;

import java.util.Scanner;

public class MaxSum1003_2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n > 0){
			String input = scanner.nextLine();
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
		int max = 0;
		int sum = 0;
		for(int k=0; k<arr.length; k++){
			sum += arr[k];
			if(sum > max){
				max = sum ;
				maxIndex = k;
			}else if(sum < 0){
				sum = 0;
				minIndex = k;
			}
			
			
		}

		return new int[]{max, minIndex+1, maxIndex+1};
	}

}
