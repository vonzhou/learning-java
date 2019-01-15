package oj.leetcode;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric
 *  characters and ignoring cases.
 *  
 *  For example,
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *  "race a car" is not a palindrome.
 *  
 *  Note:
 *  Have you consider that the string might be empty? 
 *  This is a good question to ask during an interview.
 *  
 *  For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if(s == null)
			return false;
		s = s.replace(" ", "");
		// �մ��ǻ���
		if(s.equals(""))
			return true;
		
		char[] cs = s.toCharArray();
		//we just need alphanumeric
		int index = 0;
		for(int i = 0; i < cs.length; i++){
			if(Character.isAlphabetic(cs[i]) || Character.isDigit(cs[i]))
				cs[index++] = cs[i];
		}
		int left = 0, right = index - 1;
		while(left < right){
			char a = Character.toLowerCase(cs[left]);
			char b = Character.toLowerCase(cs[right]);
			if(a != b)
				return false;
			left ++;
			right --;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String x = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(x));
		System.out.println(Character.toLowerCase('2'));
	}
}
