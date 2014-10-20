package oj.leetcode.sort;

import java.util.Arrays;


/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized 
 * in A and B are m and n respectively.
 */
public class MergeSortedArray {
	//从后往前遍历，合并
    public static void merge(int A[], int m, int B[], int n) {
        int ia = m -1, ib = n - 1, index = m + n - 1;
        while(ia >= 0 && ib >= 0){
        	if(A[ia] > B[ib])
        		A[index--] = A[ia--];
        	else A[index--] = B[ib--];
        }
        
        while(ib >= 0){
        	A[index --] = B[ib --];
        }
        // 如果是A长的话，已经在位
    }
    
    public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 0;
		a[1] = 20;
		int[] b = {5,7,11,34,56};
		merge(a, 2, b, 5);
		System.out.println(Arrays.asList(a));
	}
}
