package effectivejava.chapter4.Item21;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String[] ss = {"abcefdfdf","vonzhou",};
		Arrays.sort(ss, Host.STRING_LEN_COMPARATOR);
		System.out.println(Arrays.toString(ss));
		Arrays.sort(ss, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(ss));
	}

}
