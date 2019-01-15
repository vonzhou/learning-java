package oj.leetcode;

public class MedianOfTwoSortedArrays {

    /**
     * 不需要全部排序，排序一半  O((m+n)/2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int i = 0, j = 0, z = 0;
        int[] sorted = new int[total];
        int mid = total / 2;

        while (z <= mid + 1 && i < m && j < n) {
            sorted[z++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
        }

        // 有一个数组遍历完了
        while (z <= mid) {
            if (i < m) {
                sorted[z++] = nums1[i++];
            }
            if (j < n) {
                sorted[z++] = nums2[j++];
            }
        }

        return (total % 2 == 1) ? sorted[mid] : (sorted[mid] + sorted[mid - 1]) / 2.0;
    }

}
