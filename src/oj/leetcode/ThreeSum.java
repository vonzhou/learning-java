package oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * 注意:不能有重复的三元组
 */
public class ThreeSum {
    /**
     * TODO 暴力法
     */
    public List<List<Integer>> threeSum1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3)
            return res;

        return null;
    }

    /**
     * AC
     * 排序,然后二分查找的思想
     * 耗时48ms
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums); // O(n log(n))

        int len = nums.length;
        int j = 0, k = 0;
        List<Integer> one = null;

        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int target = -nums[i];
                j = i + 1;
                k = len - 1;
                // binary search num[i]'s right part
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum == target) {
                        // find a triple
                        one = new ArrayList<Integer>(3);
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[k]);
                        res.add(one);

                        j++; // 有一个不变的话  肯定存在重复的 <a,b,c>
                        // 这里就看数值 ， 虽然对象时不同的, 所以 set.contains(one)会失败
                        // 因为 [0,0,0],[0,0,0]可以使俩不同的List
                        //NB 消除重复的数值，而不是看一个List是否已经存在
                        while (j < k && nums[j] == nums[j - 1])
                            j++;

                        k--; // 同理
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (sum > target) {
                        k--;
                    } else
                        j++;
                }// end while
            }
        }

        return res;
    }


    /**
     * Time Limit Exceeded
     * 思路一样,Triple去重的方法变了
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums); // O(n log(n))

        int len = nums.length;
        int j = 0, k = 0;
        List<Integer> one = null;
        // handle duplicate
        MySet set = new MySet();

        for (int i = 0; i < len - 2; i++) {
            int target = -nums[i];
            j = i + 1;
            k = len - 1;
            // binary search num[i]'s right part
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    // find a triple
                    one = new ArrayList<Integer>(3);
                    one.add(nums[i]);
                    one.add(nums[j]);
                    one.add(nums[k]);
                    Triple cur = new Triple(nums[i], nums[j], nums[k]);
                    if (!set.contains(cur)) {
                        set.add(cur);
                        res.add(one);
                    }

                    j++;
                    k--;
                } else if (sum > target) {
                    k--;
                } else
                    j++;
            }// end while
        }

        return res;
    }

    static class Triple {
        int a, b, c;

        public Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Triple) {
                Triple tmp = (Triple) obj;
                if (a == tmp.a && b == tmp.b && c == tmp.c)
                    return true;
                return false;
            } else
                return false;
        }
    }

    static class MySet {
        List<Triple> storage = new ArrayList<Triple>();

        public void add(Triple x) {
            if (!contains(x))
                storage.add(x);
        }

        public boolean contains(Triple x) {
            for (Triple t : storage) {
                if (t.equals(x)) {
                    System.out.println("true");
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int num[] = {0, 0, 0, 0};
        List<List<Integer>> list = new ThreeSum().threeSum2(num);
        System.out.println(list);
        System.out.println("--------------");
        Triple t1 = new Triple(0, 0, 0);
        Triple t2 = new Triple(0, 0, 0);
        MySet set = new MySet();
        set.add(t1);
        System.out.println(set.contains(t2));
    }
}



/*
 * Input: [0,0,0,0] Output: [[0,0,0],[0,0,0]] Expected: [[0,0,0]]
 */

