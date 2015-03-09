package oj.swordoffer;

public class NumberKInSortedArr {
	
	public int getNumberOfK(int[] data, int len, int k){
		if(data == null || len <= 0)
			return 0;
		
		int first = getFirstK(data,len, k, 0, len-1);
		int last = getLastK(data,len, k, 0, len-1);
		
		if(first>-1 && last >-1)
			return last-first + 1;
		
		return 0;
	}

	public int getLastK(int[] data, int len, int k, int from, int to) {
		if(from > to)
			return -1;
		int mid = (from + to)/2;
		int midData = data[mid];
		if(midData == k){
			if((mid < len-1 && data[mid+1] != k) || mid==len-1 )
				return mid;
			else 
				from = mid + 1;
		}else if(midData > k)
			to = mid - 1;
		else 
			from = mid + 1;
		
		return getLastK(data, len, k, from, to);
	}

	public int getFirstK(int[] data, int len, int k, int from, int to) {
		if(from > to)
			return -1;
		int mid = (from + to)/2;
		int midData = data[mid];
		if(midData == k){
			if((mid > 0 && data[mid-1] != k) || mid==0 )
				return mid;
			else 
				to = mid - 1;
		}else if(midData > k)
			to = mid - 1;
		else 
			from = mid + 1;
		
		return getFirstK(data, len, k, from, to);
	}
	
	public static void main(String[] args) {
		NumberKInSortedArr test = new NumberKInSortedArr();
		int[] a = {1,2,3,3,4,4,4,5,8,30,};
		//System.out.println(test.getFirstK(a, a.length, 8, 0, a.length));
		//System.out.println(test.getLastK(a, a.length, 0, 0, a.length));
		System.out.println(test.getNumberOfK(a, a.length, 4));
	}

}
