package algrithm.sedgewick.strings;

/**
 * 9. Reverse a string. 
 * Write a recursive function to reverse a string. Do not use any loops. 
 * Hint: use the String method substring().
 */
public class StringReverse {
	
	/*
	 * native way 
	 */
	public static String reverse1(String s){
		if(s == null || s.equals(""))
			return s;
		
		String res = "";
		int len = s.length();
		for(int i=len-1; i >= 0 ; i--)
			res = res + s.charAt(i);
		
		return res;
	}
	
	/*
	 * using StringBuilder
	 */
	public static String reverse2(String s){
		if(s == null )
			return s;
		if(s.length() <= 1)
			return s;
		
		StringBuilder res = new StringBuilder();
		int len = s.length();
		for(int i=len-1; i >= 0 ; i--)
			res.append(s.charAt(i));
		
		return res.toString();
	}
	
	/*
	 * a better recursive way
	 * a linearithmic running time. ÈçºÎ·ÖÎö£¿£¿£¿£¿£¿
	 */
	public static String reverse(String s){
		if(s == null )
			return s;
		if(s.length() <= 1)
			return s;
		
		int n = s.length();
		String left = s.substring(0, n/2);
		String right = s.substring(n/2, n);
		
		return reverse(right)+ reverse(left);
	}
	
	public static void main(String[] args) {
		String s = "test";
		System.out.println(reverse(s));
		System.out.println(reverse1(s));
		System.out.println(reverse2(s));
	}

}
