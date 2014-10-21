package oj.leetcode.binarysearch;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
	
	// 通过划分成子数组之后，总有一半是有序的，只需要在另一半中不断查找
	// 注意这种分而治之的思想，不断缩小逆序子数组的尺寸
	/*
	 * When you split the sorted, rotated array into two halves (arr[1],..,arr[mid])
	 * and (arr[mid+1],..,arr[n]), one of them is always sorted and the other always
	 * has the min. We can directly use a modified binary search to keep searching
	 * in the unsorted half
	 */
	public int findMin(int[] num) {
		if(num == null || num.length == 0)
			return 99999;  // fixme
		int first = 0, last = num.length - 1;
		int mid;
		while(num[first] > num[last]){
			mid = first + (last - first)/2;
			if(num[mid] > num[last])
				first = mid + 1;
			else last = mid;
		}
		return num[first];      
	}
	
	
	// 用最直接的方法  O(N) 虽然能AC
	public int findMin2(int[] num) {
		if(num == null || num.length == 0)
			return 99999;  // fixme
		int len = num.length;
		int i = 0;
		while(i < len-1 && num[i] < num[i+1])
			i++;
		
		if(i == len - 1)
			return num[0];
		else return num[i+1];
	}
	
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray ff = new FindMinimumInRotatedSortedArray();
		int[] num = { 4, 5, 6, 7, 0, 1, 2};
		System.out.println(ff.findMin2(num));
		System.out.println(ff.findMin(num));
	}
}
