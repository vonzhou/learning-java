package oj.leetcode;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Created by vonzhou on 2019/2/16.
 */
public class KthLargestElementInArray {

    /**
     * AC
     * 直接先排序
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public static void main(String[] args) {
        System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
