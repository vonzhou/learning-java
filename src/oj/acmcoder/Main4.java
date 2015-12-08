package oj.acmcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=0; i<T; i++){

			int n = s.nextInt();
			int[] arr = new int[n];
			for(int j=0; j<n; j++){
				arr[j] = s.nextInt();
			}
			
			
			System.out.println(pairCount(arr));
		}
	}

	private static int pairCount(int[] arr) {
		if(arr == null || arr.length <=2)
			return 0;
		
		Arrays.sort(arr);
		
		
		
		int last = arr.length-1;
		int count = 0;
		boolean flag = true;
		while(flag){
			if(arr[last] >=1 && arr[last-1] >=1 && arr[last-2] >=1){
				count ++;
				arr[last] --;
				arr[last-1] --;
				arr[last-2] --;
				// sort
				//Arrays.sort(arr);
				int i= last-2;
				int tmp;
				while(i >0 && arr[i] < arr[i-1]){
					
					tmp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = tmp;
					i--;
				}
//				int tmp = arr[i];
//				arr[i] = arr[last-2];
//				arr[last-2] = tmp;
				
				 i= last-1;
					while(i >0 && arr[i] < arr[i-1]){
						
						tmp = arr[i];
						arr[i] = arr[i-1];
						arr[i-1] = tmp;
						i--;
					}
					
//					tmp = arr[i];
//					arr[i] = arr[last-1];
//					arr[last-1] = tmp;
					
					 i= last;
						while(i >0 && arr[i] < arr[i-1]){
							
						tmp = arr[i];
						arr[i] = arr[i-1];
						arr[i-1] = tmp;
						i--;
					}
				
				
			}else
				flag = false;
		}
		
		
			
		return count/2;
	}
//
//	private static void insertSort(int[] arr) {
//		for(int i=1; )
//	}

}
