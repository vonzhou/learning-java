package oj.leetcode.stack;

import java.util.Stack;


/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 *  valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if(s == null || s.equals(""))
			return true;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			char cur = s.charAt(i);
			if(stack.isEmpty() || isLeft(cur))
				stack.push(cur);
			else if(isRight(cur)){
				char cmp = stack.peek();
				if(match(cur,cmp))
					stack.pop();
			}else{
				// ·Ç·¨×Ö·û
				return false;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}

	// ×óÓÒÀ¨ºÅÆ¥Åä
	private boolean match(char cur, char cmp) {
		if((cur==')'&&cmp=='(') || (cur=='}'&&cmp=='{') || (cur==']'&&cmp=='['))
			return true;
		return false;
	}

	private boolean isRight(char cur) {
		if(cur==')' || cur=='}' || cur==']')
			return true;
		return false;
	}

	private boolean isLeft(char cur) {
		if(cur=='(' || cur=='{' || cur=='[')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		ValidParentheses t = new ValidParentheses();
		System.out.println(t.isValid("([)]"));
	}
}
