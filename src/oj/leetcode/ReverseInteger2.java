package oj.leetcode;

public class ReverseInteger2 {
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			// System.out.println(res + "   " + x);
		}
		return res;
	}

	public static void main(String[] args) {
		ReverseInteger2 ri = new ReverseInteger2();
		int x = 1000000003;
		// 输入大数没有报错，但是结果奇怪！！！
		System.out.println(ri.reverse(x));
	}
}
