package oj.leetcode;

import java.util.Arrays;

/**
 * 128. Longest Consecutive Sequence]
 * Created by vonzhou on 2019/2/16.
 */
public class LongestConsecutiveSequence {

    /**
     * AC
     * 先排序,然后寻找符合条件的序列
     * 难点在于: 需要去重
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        // 去重
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // 注意,如果i没有递进,长度是1,而不是0
        int L = i + 1;
//        Util.printArr(nums);


        if (L == 1) {
            return 1;
        }

        i = 0;
        int max = 0;
        while (i < L) {
            int start = i;
            while (start + 1 < L && nums[start] == nums[start + 1] - 1) {
                start++;
            }

            int len = start - i + 1;
            max = len > max ? len : max;

            i = start + 1;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{98, 100, 101, 200, 1, 3, 2, 102, 99}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 0}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, -1}));
    }
}
