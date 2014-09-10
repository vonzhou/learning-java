package oj.leetcode;

// no. 1

public class ReverseStringInWords {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";

		// split() 会包含字符串开头空串
		String arr[] = s.split(" ");
		if (arr.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals(""))
				sb.append(arr[i]).append(" ");
		}

		// 去掉最后一个空格
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
	}

	public static void main(String[] args) {
		String s = "   rwerqwe vwrtqw3 c  ";
		String arr[] = s.split(" ");
		for (int i = 0; i < arr.length; i++)
			System.out.println("=" + arr[i] + "=");
		System.out.println(new ReverseStringInWords().reverseWords(s) + "=");
	}
}
