package oj.leetcode.string;

/*
 * Validate if a given string is numeric.
 * Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. 
 You should gather all requirements up front before implementing one.
 进行重构，理清思路，而不是纯粹为了得到结果。
 */
public class ValidNumber2 {
	public boolean isNumber(String s) {
		if (s == null || s.equals(""))
			return false;

		s = s.trim();// 开头结尾的空白除去
		if (s.equals(""))
			return false;

		return isInteger(s) || isDouble(s) || isScientific(s);
	}

	// 科学计数法，e 和 E 都是合法的
	public boolean isScientific(String s) {
		if (!(s.contains("e") || s.contains("E")))
			return false;
		// 包含多个 e也是不行的 
		int j = s.indexOf('E');
		int i = s.indexOf('e');
		if(j != -1)
			i = j;
		
		// e 在最后
		if (i >= (s.length() - 1))
			return false;

		String left = s.substring(0, i);
		String right = s.substring(i + 1, s.length());
	

		// System.out.println(left + ":"+right);
		return (isDouble(left) || isInteger(left))
				&& isInteger(right);
	}

	// 浮点数 
	public boolean isDouble(String s) {
		if (!s.contains("."))
			return false;
		int i = s.indexOf('.');

		String left = s.substring(0, i);
		// 如果小数点在最后的话，返回的是空串 对浮点数来说 是可以的
		String right = s.substring(i + 1, s.length());
		boolean b1 = false;
		boolean b2 = false;
		boolean flag = false;  // 左右两边不能同时为空
		
		if(left.length() <= 1){// 对只有一个字符的情况单独考虑
			if(left.equals("")) {
				b1 = true;
				flag = true;
			}else{
				char c = left.charAt(0);
				b1 = (c == '+' || c == '-') || isDigit(c);
				flag = flag || (c == '+' || c == '-');
			}
			
		}else{
			b1 = isInteger(left);
		}
		
		if(flag)
			b2 =  isUnsignedInteger(right);
		else b2 =  right.equals("") || isUnsignedInteger(right);

		return b1 && b2;
	}

	// 考虑开头的正负号
	public boolean isInteger(String s) {
		if (s.equals(""))
			return false;
		// 符号的处理
		char first = s.charAt(0);
		if ((first >= '0' && first <= '9'))
			return isUnsignedInteger(s);
		else if (first == '+' || first == '-') {
			if (s.length() > 1)
				return isUnsignedInteger(s.substring(1));
		}

		return false;
	}

	// 不带符号的整数
	private boolean isUnsignedInteger(String s) {

		if (s.equals(""))
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (!isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	// 是数字
	private boolean isDigit(char c) {
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidNumber2 vn = new ValidNumber2();
		String s = ".";
		System.out.println(s.substring(1, 1)); // 会返回空串  
		System.out.println(3.);
		System.out.println(0.);
		System.out.println(.1);
		System.out.println(-0);
		System.out.println(-.0);
		System.out.println(-.0);
		System.out.println(.0E-0);
		System.out.println(+1e0);
		System.out.println(vn.isScientific("-1.e"));
		//System.out.println(vn.isDouble("-.1"));
		//System.out.println(vn.isNumber("005047e+6"));
	}
}
