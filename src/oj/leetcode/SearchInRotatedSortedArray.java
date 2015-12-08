package oj.leetcode;

/*

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 
 
 O(lgN)
 */
public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length <= 0)
			return -1;
		
		int lo = 0, hi = nums.length -1 ;
		int mid = 0;
		while(lo < hi){
			mid = (lo + hi)/2;
			if(nums[mid] > nums[hi])
				lo = mid + 1;
			else hi = mid;
		}
		// get here, lo==hi
		// this is the rotate point
		
		int rotate = lo;

		// binary search in left part
		lo = 0;
		hi = rotate - 1;
		while(lo <= hi){
			mid = (lo+hi)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				hi = mid -1;
			else lo = mid + 1;
		}

		// binary search in right part
		lo = rotate;
		hi = nums.length - 1;
		while(lo <= hi){
			mid = (lo+hi)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				hi = mid -1;
			else lo = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int a[] = {4,5,6,7,0,1,2};
		System.out.println(search(a, 0));
		
		int b[] = {6,7,0,1,2, 5};
		System.out.println(search(b, 0));
		
		int c[] = {4};
		System.out.println(search(c, 4));
	}
}










