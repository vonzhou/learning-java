package oj.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c 
 * in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *        
 */
public class ThreeSum {
	/*
	 * 暴力法，效率低
	 */
	public List<List<Integer>> threeSum1(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3)
			return res;

		return null;
	}

	/*
	 * 先排序，然后进行二分查找 为了防止重复的triple，用集合处理
	 */
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3)
			return res;

		Arrays.sort(num); // O(n log(n))

		int len = num.length;
		int j = 0, k = 0;
		List<Integer> one = null;

		for (int i = 0; i < len - 2; i++) {
			if (i == 0 || num[i] > num[i - 1]) {
				int target = -num[i];
				j = i + 1;
				k = len - 1;
				// binary search num[i]'s right part
				while (j < k) {
					int sum = num[j] + num[k];
					if (sum == target) {
						// find a triple
						one = new ArrayList<Integer>(3);
						one.add(num[i]);
						one.add(num[j]);
						one.add(num[k]);
						res.add(one);
						j++; // 有一个不变的话 肯定存在重复的 <a,b,c>
								// 这里就看数值 ， 虽然对象时不同的, 所以 set.contains(one)会失败
								// 因为 [0,0,0],[0,0,0]可以使俩不同的List
						// NB 消除重复的数值，而不是看一个List是否已存在
						while (j < k && num[j] == num[j - 1])
							j++;

						k--; // FIXME
						while (j < k && num[k] == num[k + 1])
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


	/*
	 * 为了防止重复的triple，不能用JCF的HashSet ，自己实现一个符合自己意图的集合
	 * fuck !没有通过AC ， Submission Result: Time Limit Exceeded
	 */
	public List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3)
			return res;

		Arrays.sort(num); // O(n log(n))

		int len = num.length;
		int j = 0, k = 0;
		List<Integer> one = null;
		// handle duplicate
		MySet set = new MySet();

		for (int i = 0; i < len - 2; i++) {
			int target = -num[i];
			j = i + 1;
			k = len - 1;
			// binary search num[i]'s right part
			while (j < k) {
				int sum = num[j] + num[k];
				if (sum == target) {
					// find a triple
					one = new ArrayList<Integer>(3);
					one.add(num[i]);
					one.add(num[j]);
					one.add(num[k]);
					Triple cur = new Triple(num[i], num[j], num[k]);
					if(! set.contains(cur)){
						set.add(cur);
						res.add(one);
					}
					
					j++; // 有一个不变的话 肯定存在重复的 <a,b,c>
							// 这里就看数值 ， 虽然对象时不同的, 所以 set.contains(one)会失败
							// 因为 [0,0,0],[0,0,0]可以使俩不同的List
					// NB 消除重复的数值，而不是看一个List是否已存在
					k--; // FIXME
				} else if (sum > target) {
					k--;
				} else
					j++;
			}// end while
		}

		return res;
	}

	public static void main(String[] args) {
		int num[] = { 0, 0, 0, 0 };
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

class Triple {
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

class MySet {
	List<Triple> storage = new ArrayList<Triple>();
	
	public void add(Triple x) {
		if (!contains(x))
			storage.add(x);
	}

	public boolean contains(Triple x) {
		for (Triple t : storage) {
			if (t.equals(x))
				{System.out.println("true");return true;}
		}
		return false;
	}
}

/*
 * Input: [0,0,0,0] Output: [[0,0,0],[0,0,0]] Expected: [[0,0,0]]
 */

