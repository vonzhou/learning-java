package oj.leetcode.array;

import java.util.Arrays;


/*
 * Given a sorted array, remove the duplicates in place such that each element 
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place 
 * with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 *Your function should return length = 2, and A is now [1,2].
 *
 *相关题目： Remove Element
 */
public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] A) {
		if(A == null ||A.length == 0)
			return 0;
		int index = 0;
		for(int i = 1; i <A.length; i++)
			if(A[i] != A[index]){
				A[++index] = A[i];
			}
		
		return index + 1;
	}
	
	// 测试，虽然是值传递，但是对应的底层元素只有一份，所以会改变
	public static void func(int[] a){
		a[0] = 100;
	}
	public static void showArray(int[] a){
		if(a == null)
			return ;
		for(int i = 0; i< a.length;i++)
			System.out.print(a[i] + " ,");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {1,2,2,2,34,45,55,55,565};
		int len = removeDuplicates(arr);
		System.out.println("arr len : " + len);
		showArray(arr);
		
		arr = null;
		len = removeDuplicates(arr);
		System.out.println("arr len : " + len);
		showArray(arr);
		
	}
}
	        
		   
