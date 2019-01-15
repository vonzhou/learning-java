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
 
 �ύ��10�� ����AC��
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		if(s == null || s.equals(""))
			return false;
		
		s = s.trim();// ��ͷ��β�Ŀհ׳�ȥ
		if(s.equals(""))
			return false;
		
		// ���ŵĴ���
		char first = s.charAt(0);
		if((first >= '0' && first <= '9') || first == '.')
			return isPureNumber(s);
		else if(first == '+' || first == '-'){
			if(s.length() > 1)
				return isPureNumber(s.substring(1));
		}
		
		return false;
	}
	
	public boolean isPureNumber(String s) {
		return isInteger(s) || isDouble(s) || isScientific(s);
	}
	
	
	
	// ��ѧ����������eΪ�߽�
	private boolean isScientific(String s) {
		if(! s.contains("e"))
			return false;
		int i = s.indexOf('e');
		if(i >= (s.length()-1))
			return false;
		
		String left = s.substring(0,i);
		String right = s.substring(i+1, s.length());
		// ָ�����Դ�����
		if(right.length() == 1)
			return (isDouble(left)||isInteger(left)) && isInteger(right);
		
		if(right.charAt(0) == '+' || right.charAt(0) == '-' )
			right = right.substring(1);
		
		//System.out.println(left + ":"+right);
		return (isDouble(left)||isInteger(left)) && isInteger(right) ;
	}
	private boolean isDouble(String s) {
		if(! s.contains("."))
			return false;
		int i = s.indexOf('.');
		
		String left = s.substring(0,i);
		String right = s.substring(i+1, s.length());
		
		boolean b1 = (left.equals("") || isInteger(left)) && isInteger(right) ;
		boolean b2 = (isInteger(left)) && (right.equals("") ||isInteger(right)) ;
		
		return b1||b2;
	}
	private boolean isInteger(String s) {
		
		if(s.equals(""))
			return false;
		
		for(int i = 0; i < s.length(); i++){
			if(! isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
	private boolean isDigit(char c) {
		if(c >= '0' && c <= '9')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		String s = ".12";
		System.out.println(3.);
		System.out.println(.1);
		System.out.println(-.0);
		System.out.println(2e0);
		
		System.out.println(vn.isNumber("005047e+6"));
	}
}



