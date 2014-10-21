package oj.leetcode.binarysearch;


/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if(A == null || A.length == 0)
			return 0;
		int first = 0, last = A.length - 1;
		int mid;
		while(first <= last){
			mid = first + (last -  first)/2;
			if(A[mid] == target)
				return mid;
			else  if(target > A[mid])
				first = mid + 1;
			else last = mid - 1;
		}
		
		return first;
	}		    
	
	public static void main(String[] args) {
		SearchInsertPosition si = new SearchInsertPosition();
		int[] a = {1,3,5,6};
		System.out.println(si.searchInsert(a, 0));
	}
}





