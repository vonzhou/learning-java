package oj.leetcode;

/*
 * Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution 
 * using the divide and conquer approach, which is more subtle.
 * 
 * 
 */
public class MaximumSubarray {

    /**
     * AC
     * 暴力法, O(N^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;  // invalid

        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                max = sum > max ? sum : max;
            }
        }

        return max;
    }

    /*
     * 2. ˼ά���� ��֪��ͨ
     * ��ǰ���󻬶� �������ǰһ�����ֺ��ܹ�ʹ������ �͸��� ������Ӹ�λ�������ۼ�
     * ��̬�滮  --   O(n)
     * ��μ�¼��λ����Ϣ����
     */

    /**
     * 动态规划
     * f(n) = { f(n-1)>0 ? f(n-1) : 0 } + nums[n-1]
     * f(0) = 0
     * f(1) = nums[0]
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;  // invalid

        int len = nums.length;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            // 动态规划,动态的做决定要不要加上前面的和
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    /*
     * ���÷��η� ���ӳ�����Զ��׼�
     * ���������б�Ҫ�� ���� 2.c ����Ľⷨ����������˼· ���Ӷ� O(n),����֮�������� logn
     * Using Divide and Conquer approach, we can find the
     * maximum subarray sum in O(nLogn) time.
     * 1) Divide the given array in two halves
     * 2) Return the maximum of following three
     *  a) Maximum sub array sum in left half
     *  b) Maximum sub array sum in right half
     *  c) Maximum sub array sum such that the subarray crosses the midpoint
     */
    public static int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return Integer.MIN_VALUE;  // invalid

        return maxSub(A, 0, A.length - 1);
    }

    private static int maxSub(int[] A, int from, int to) {

        if (from == to)
            return A[from];
        int mid = (from + to) / 2;
        int maxLeft = maxSub(A, from, mid);
        int maxRight = maxSub(A, mid + 1, to);

        // the sub array cross the midpoint
        int leftTemp = 0, maxMidToLeft = Integer.MIN_VALUE;
        int rightTemp = 0, maxMidToRight = Integer.MIN_VALUE;
        for (int i = mid; i >= from; i--) {
            leftTemp += A[i];
            if (leftTemp > maxMidToLeft)
                maxMidToLeft = leftTemp;
        }
        for (int i = mid + 1; i <= to; i++) {
            rightTemp += A[i];
            if (rightTemp > maxMidToRight)
                maxMidToRight = rightTemp;
        }

        return Math.max(Math.max(maxRight, maxLeft), (maxMidToLeft + maxMidToRight));
    }

    public static void main(String[] args) {
        int A[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(A));
        System.out.println(maxSubArray1(new int[]{-2, -1}));
//        System.out.println(maxSubArray(A));
    }
}





















