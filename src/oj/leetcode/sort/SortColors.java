package oj.leetcode.sort;


/*
 * Given an array with n objects colored red, white or blue,
 *  sort them so that objects of the same color are adjacent, 
 *  with the colors in the order red, white and blue.
 *  
 *  Here, we will use the integers 0, 1, and 2 to represent the color red,
 *   white, and blue respectively.
 *   Note:
 *   You are not suppose to use the library's sort function for this problem.
 *   
 *  Follow up:
 *  A rather straight forward solution is a two-pass algorithm using counting sort.
 *  First, iterate the array counting number of 0's, 1's, and 2's, 
 *  then overwrite array with total number of 0's, then 1's and followed by 2's.
 *  
 *  Could you come up with an one-pass algorithm using only constant space?
 *  
 *  1.这种直接计数的方法有点哈希的思想，这里的键就三个；
 *  2.联想到了 快排在处理重复元素时的策略 ， 三段切分[<v, = v, >v]
 */
public class SortColors {
	// 1. 计数排序
	   public void sortColors(int[] A) {
		   if(A == null || A.length == 0)
			   return;
		   int reds = 0, whites = 0, blues = 0;
		   // one pass for count 0,1,2
		   for(int i = 0; i < A.length; i++){
			   if(A[i] == 0) reds += 1;
			   if(A[i] == 1) whites += 1;
			   if(A[i] == 2)  blues += 1;
		   }
		   
		   // one pass for construct the res array
		   int i = 0;
		   while(i < reds)
			   A[i++] = 0;
		   while(i < reds + whites)
			   A[i++] = 1;
		   while(i < reds + whites + blues)
			   A[i++] = 2;
	   }    
	   
	   // 2. 利用双指针 ， 分别从前，后构造（向中间前进）
	   public void sortColors2(int[] A) {
		   if(A == null || A.length == 0)
			   return;
		   int red = 0, blue = A.length -1;
		   int i = 0;
		   while(i < blue + 1){
			   if(A[i] == 0)
				   swap(A, i++, red++);
			   else if(A[i] == 2)
				   swap(A, i, blue--);// 这里i没有推进，因为对调过来的颜色需要判断
			   else i++;
		   }
	   }
	   
	   private void swap(int[] a,int i, int j) {
		   int tmp = a[i];
		   a[i] = a[j];
		   a[j] = tmp;
	   }

	public static void main(String[] args) {
		int a[] = {0,0,2,2,1,0,2,};
		SortColors sc = new SortColors();
		sc.sortColors2(a);
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}
