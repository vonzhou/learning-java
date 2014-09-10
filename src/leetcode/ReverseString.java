package leetcode;

public class ReverseString {

	public String reverseWords(String s) {
		s = s.trim(); // imit the head and tail blanks
		int i = 0;

		int count = 0;
		StringBuffer sb = new StringBuffer();
		// imit the inter multi space
		while (i < s.length()) {
			if (s.charAt(i) != ' ') {
				if (count > 1)
					count = 0;
				sb.append(s.charAt(i));
			} else {
				count++;
				if (count == 1)
					sb.append(' ');
			}
			i++;
		}

		s = reverseWord((new String(sb)));
		StringBuffer res = new StringBuffer();
		i = 0;
		for (int j = i; j < s.length(); j++) {
			if (s.charAt(j) == ' ') {
				// reverse the word
				res.append(s.substring(i, j));
				i = j + 1;
			}
			//
		}

		return res.toString();
	}

	public String reverseWord(String s) {
		char[] cs = s.toCharArray(); // can use replace()
		for (int i = 0; i < cs.length / 2; i++) {
			char temp = cs[i];
			cs[i] = cs[cs.length - i - 1];
			cs[cs.length - i - 1] = temp;
		}
		return new String(cs);
	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseWords("    von   zho    "));
	}

}
