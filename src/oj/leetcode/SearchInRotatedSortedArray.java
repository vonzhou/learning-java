package oj.leetcode;


/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    /**
     * AC
     * 耗时6ms
     * 先找到旋转点,然后使用二分查找在左右部分进行查找目标
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return -1;

        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) >>> 1;  // 应该比 /2 要快
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else hi = mid;
        }
        // get here, lo==hi
        // this is the rotate point

        int rotate = lo;

        // binary search in left part
        lo = 0;
        hi = rotate - 1;
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                hi = mid - 1;
            else lo = mid + 1;
        }

        // binary search in right part
        lo = rotate;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(a, 0));

        int b[] = {6, 7, 0, 1, 2, 5};
        System.out.println(search(b, 0));

        int c[] = {4};
        System.out.println(search(c, 4));
    }
}










