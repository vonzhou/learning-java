package oj.leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0)
			return -1;
		// 两个相同的数异或运算后为0，巧妙
		int res = 0;
		for (int i = 0; i < A.length; i++)
			res ^= A[i];

		return res;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 4, 1, 6, 100, 7, 8, 8, 7, 6, };

		System.out.println(new SingleNumber().singleNumber(a));
	}
}
