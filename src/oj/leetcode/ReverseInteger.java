package oj.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int flag = x >= 0 ? 1 : -1; // positive or negative
		x = x * flag; // abs

		if (x == 0)
			return 0;

		// reverse the int
		StringBuilder sb = new StringBuilder(Integer.toString(x));
		sb.reverse();

		// overflow,NB: long
		if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE)
			return 0;

		// cut the 0s in the head
		String s = sb.toString();
		int i = 0;
		for (i = 0; i < s.length() && s.charAt(i) == '0'; i++)
			;
		s = s.substring(i);

		return Integer.parseInt(s) * flag;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		int x = 1000000003;// »á³ö´í!!!!!
		// int x = -1230;
		System.out.println(ri.reverse(x));

	}
}
