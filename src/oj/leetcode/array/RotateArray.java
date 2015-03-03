package oj.leetcode.array;

/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 
 * different ways to solve this problem.
 * [Hint]:
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * 
 */
public class RotateArray {

	/*
	 * 1. 最蠢的方法 开辟空间 O(k)
	 * Accept !!!
	 */
	public void rotate1(int[] nums, int k) {
		if(nums.length <=1 || k <= 0)
			return;
		int[] aux = new int[k];
		
		k %= nums.length;
		for(int i=nums.length -k, j = 0; i < nums.length; i++, j++)
			aux[j] = nums[i];
		// 从后往前移
		for(int i = nums.length - k - 1; i >= 0; i--)
			nums[i+k] = nums[i];
		for(int i=0; i < k; i++)
			nums[i] = aux[i];
	}
	
	/*
	 * 2. Reverse 三次 ，结构清晰, 符合in-place with O(1) extra space
	 */
	public void rotate(int[] nums, int k) {
		if(nums.length <=1 || k <= 0)
			return;
		k %= nums.length;
		k = nums.length -k;
		reverse(nums, 0,k-1);
		reverse(nums, k, nums.length-1);
		reverse(nums, 0, nums.length-1);
	}
	public void reverse(int[] a, int from, int to){
		if(from >= to)
			return;
		for(int i = from; i <= from + (to-from)/2; i++){
			int tmp = a[i];
			a[i] = a[to-i+from];
			a[to-i+from] = tmp; 
		}
	}
	
	
	
	
	
	
	public static void show(int[] arr){
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void test1(){
		int[] nums = {1,2,3,4,5,6,7};
		int k =3;
		new RotateArray().rotate(nums, k);
		show(nums);
	}
	public static void test2(){
		int[] nums = {1,2,3,4,5,6,7};
		int k =3;
		new RotateArray().reverse(nums, 0, nums.length - 1);
		show(nums);
	}
	public static void main(String[] args) {
		test1();
	}
}
