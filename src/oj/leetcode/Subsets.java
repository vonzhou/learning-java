package oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		if (S == null || S.length == 0)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 对该数组进行升序排序
		Arrays.sort(S);

		int n = S.length; // number of elements
		long len = 1 << n;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0)
					list.add(S[j]);
			}
			result.add(list);
			// 为下一个子集合链表做准备
			list = new ArrayList<Integer>();
		}

		return result;
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		List<List<Integer>> sub = s.subsets(new int[] { 0 });
		System.out.println(sub);
	}
}
