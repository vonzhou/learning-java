package oj.leetcode.binarysearch;


/*
 * Given a sorted array of integers, find the starting and ending position 
 * of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * ¶ş·Ö²éÕÒ
 * 
 * 
 */
public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		if(A == null || A.length == 0)
			return null;
		int[] res = new int[]{lowerBound(A, target), upperBound(A, target)};
		return res;
	}
	
	public int lowerBound(int[] A, int target){
		int first = 0, last = A.length - 1;
		int mid;
		while(first + 1 < last){
			mid = first + (last - first) / 2;
			if(A[mid] == target) last = mid;
			else if(target > A[mid]) first = mid;
			else last = mid;
		}
		if(A[first] == target)
			return first;
		else if(A[last] == target)
			return last;
		return -1;
	}
	
	public int upperBound(int[] A, int target){
		int first = 0, last = A.length - 1;
		int mid;
		while(first + 1 < last){
			mid = first + (last - first) / 2;
			if(A[mid] == target) first = mid;  //
			else if(target > A[mid]) first = mid;
			else last = mid;
		}
		
		if(A[last] == target)
			return last;
		else if(A[first] == target)
			return first;
		else return -1;
	}
	public int lowerBound2(int[] A, int target){
		int first = 0, last = A.length - 1;
		int mid;
		while(first<= last){
			mid = first + (last - first) / 2;
			if(A[mid] == target) last = mid - 1;
			else if(target > A[mid]) first = mid + 1;
			else last = mid - 1;
		}
		if(A[first] == target)
			return first;
		else if(A[last] == target)
			return last;
		return -1;
	}
	
	
	
	
	public int upperBound2(int[] A, int target){
		int first = 0, last = A.length - 1;
		int mid;
		while(first <= last){
			mid = first + (last - first) / 2;
			if(A[mid] == target) first = mid + 1;  //
			else if(target > A[mid]) first = mid + 1;
			else last = mid - 1;
		}
		if(A[last] == target)
			return last;
		else if(A[first] == target)
			return first;
		else return -1;
	}
	
	public static void main(String[] args) {
		SearchForRange sf = new SearchForRange();
		int[] A = {5, 7, 7, 8, 8, 10,};
		//System.out.println(sf.lowerBound(A, 8));
		System.out.println(sf.upperBound(A, 8));
		
		int[] res = sf.searchRange(A, 8);
		System.out.println("res:" + res[0] + "," + res[1]);
	}
		   
}
















