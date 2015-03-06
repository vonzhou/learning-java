package oj.swordoffer;

public class MinNumberInRotatedArray {
	
	/*
	 * 当 arr.length =1的时候 显然出错 所以要单独考虑
	 * {1,0,1,1,1} {1,1,1,0,1}
	 */
	public static int minNotPerfect(int[] arr){
		if(arr == null || arr.length <=0 )
			return -9999;
		
		if(arr.length == 1)
			return arr[0];
		
		int p1 = 0;
		int p2 = arr.length - 1;
		int mid = p1;  // 可能已经有序了
		while(arr[p1] >= arr[p2]){
			if(p2 - p1 == 1){
				mid = p2;
				break;
			}
			mid = (p1+p2)/2;
			if(arr[mid] <= arr[p1])
				p2 = mid;
			else if(arr[mid] >= arr[p2])
				p1 = mid;
		}
		return arr[mid];
	}
	
	/*
	 * {1,0,1,1,1} {1,1,1,0,1} 当 a[p1] = a[mid]=a[p2] 不知道定位到哪边
	 * 所以只能顺序查找 ????
	 */
	public static int min(int[] arr){
		if(arr == null || arr.length <=0 )
			return -9999;
		
		if(arr.length == 1)
			return arr[0];
		
		int p1 = 0;
		int p2 = arr.length - 1;
		int mid = p1;  // 可能已经有序了
		while(arr[p1] >= arr[p2]){
			if(p2 - p1 == 1){
				mid = p2;
				break;
			}
			mid = (p1+p2)/2;
			
			if(arr[p1] == arr[mid] && arr[p2]==arr[mid])
				return bruteMin(arr, p1, p2);
			
			if(arr[mid] <= arr[p1])
				p2 = mid;
			else if(arr[mid] >= arr[p2])
				p1 = mid;
		}
		return arr[mid];
	}
	
	private static int bruteMin(int[] arr, int p1, int p2) {
		int min = arr[p1];
		for(int i=p1; i<=p2; i++){
			if(arr[i] <= min)
				min = arr[i];
		}
		return min;
	}

	/*
	 * 我的思路
	 * XXX CANNOT WORK
	 */
	public static int min2(int[] arr){
		if(arr == null || arr.length <=0 )
			return -9999;
		int p1 = 0;
		int p2 = arr.length - 1;
		int mid = p1;  
		
		while(arr[p1] >= arr[p2]){
			if(p2 == p1){
				return arr[p1];
			}
			mid = (p1+p2)/2;
			if(arr[mid] >= arr[p2])
				p1 = mid;
			else if(arr[mid] <= arr[p1])
				p2 = mid;
		}
		return arr[mid];
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,5,1,2};
		int[] b = {1};
		System.out.println(min(a));
		//System.out.println(min2(a));
		//System.out.println(min2(b));
		System.out.println("-------------------------");
		int[] c ={1,0,1,1,1};
		System.out.println(min(c));
		System.out.println(minNotPerfect(c));
		int[] d = {1,1,1,0,1};
		System.out.println(min(d));
		System.out.println(minNotPerfect(d));
	}

}
