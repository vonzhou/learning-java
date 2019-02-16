package oj.leetcode;


/* 69
 Implement int sqrt(int x).

Compute and return the square root of x.
 */

public class Sqrt {


    /**
     * AC
     * 目的就是找个整数A,使得 A^2 <= x 并且 (A+1)^2 > x
     */
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            // 使用乘法可能会溢出,所以这里采用等效的除法
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    /**
     * 为什么微调成这样就会超时??????????
     */
    public static int mySqrt2(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) >>> 1;
            // 使用乘法可能会溢出,所以这里采用等效的除法
            int remain = x / mid;
            if (mid > remain) {
                right = mid - 1;
            } else if (mid == remain) {
                return mid;
            } else {
                // 向下取整
                if ((mid + 1) > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    /**
     * 牛顿法:首先随便猜一个近似值r，然后不断令r等于r和x/r的平均数
     */
    public static int mySqrt3(int x) {
        if (x == 0)
            return 0;
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(46));
        System.out.println(mySqrt(4));
    }
}
