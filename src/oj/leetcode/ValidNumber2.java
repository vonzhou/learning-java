package oj.leetcode;

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
 �����ع�������˼·�������Ǵ���Ϊ�˵õ������
 */
public class ValidNumber2 {
	public boolean isNumber(String s) {
		if (s == null || s.equals(""))
			return false;

		s = s.trim();// ��ͷ��β�Ŀհ׳�ȥ
		if (s.equals(""))
			return false;

		return isInteger(s) || isDouble(s) || isScientific(s);
	}

	// ��ѧ��������e �� E ���ǺϷ���
	public boolean isScientific(String s) {
		if (!(s.contains("e") || s.contains("E")))
			return false;
		// ������� eҲ�ǲ��е� 
		int j = s.indexOf('E');
		int i = s.indexOf('e');
		if(j != -1)
			i = j;
		
		// e �����
		if (i >= (s.length() - 1))
			return false;

		String left = s.substring(0, i);
		String right = s.substring(i + 1, s.length());
	

		// System.out.println(left + ":"+right);
		return (isDouble(left) || isInteger(left))
				&& isInteger(right);
	}

	// ������ 
	public boolean isDouble(String s) {
		if (!s.contains("."))
			return false;
		int i = s.indexOf('.');

		String left = s.substring(0, i);
		// ���С���������Ļ������ص��ǿմ� �Ը�������˵ �ǿ��Ե�
		String right = s.substring(i + 1, s.length());
		boolean b1 = false;
		boolean b2 = false;
		boolean flag = false;  // �������߲���ͬʱΪ��
		
		if(left.length() <= 1){// ��ֻ��һ���ַ��������������
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

	// ���ǿ�ͷ��������
	public boolean isInteger(String s) {
		if (s.equals(""))
			return false;
		// ���ŵĴ���
		char first = s.charAt(0);
		if ((first >= '0' && first <= '9'))
			return isUnsignedInteger(s);
		else if (first == '+' || first == '-') {
			if (s.length() > 1)
				return isUnsignedInteger(s.substring(1));
		}

		return false;
	}

	// �������ŵ�����
	private boolean isUnsignedInteger(String s) {

		if (s.equals(""))
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (!isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	// ������
	private boolean isDigit(char c) {
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidNumber2 vn = new ValidNumber2();
		String s = ".";
		System.out.println(s.substring(1, 1)); // �᷵�ؿմ�  
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
