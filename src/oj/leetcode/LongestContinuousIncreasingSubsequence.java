package oj.leetcode;

/**
 * 674. Longest Continuous Increasing Subsequence
 * Created by vonzhou on 2019/2/16.
 */
public class LongestContinuousIncreasingSubsequence {

    /**
     * AC
     * 耗时4ms
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int longest = 0;

        int i = 0;
        while (i < nums.length) {
            int start = i;
            while (start < nums.length - 1 && nums[start] < nums[start + 1]) {
                start++;
            }
            int len = start - i + 1;
            longest = len > longest ? len : longest;

            i = start + 1;
        }


        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 3, 4, 5};
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));

        int[] nums2 = {2, 2, 2, 2};
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums2));
    }
}
