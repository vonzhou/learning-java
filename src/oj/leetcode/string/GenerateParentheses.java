package oj.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 
 */
public class GenerateParentheses {

	/*
	 * 1. 直观想法就是3个字符不同的入站出站顺序，看做是01序列 a.排列組合得到所有的可能組合（如何快速得到 ？？？） b 过滤掉不符合条件的
	 */
	public List<String> generateParenthesis(int n) {
		if (n <= 0)
			return null;
		int bits = 2 * n;
		// 所有的排列组合就是 0 - (2^bits -1)
		long sum = (1 << bits) - 1; // - 比移位运算优先级高

		List<Long> candidate = new ArrayList<Long>();
		// System.out.println(bits);
		for (long i = 0; i <= sum; i++) {
			Stack<Long> stack = new Stack<Long>();
			if (isGood(stack, i, bits)) {
				//System.out.println("good : " + i);
				candidate.add(i);
			}
		}
		// System.out.println(candidate.size());
		int size = candidate.size();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			long one = candidate.get(i);
			res.add(getParenthesisFromLong(one, bits));
		}
		return res;
	}

	private String getParenthesisFromLong(long one, int M) {
		long MASK = 0x00000001;
		String s = "";
		for (int i = 0; i < M; i++) {
			long x = one & MASK;
			one >>= 1;
			if (x == 1)
				s = "(" + s;  // 把01一一对应成()括号  所以是前插
			else
				s = ")" + s;
		}
		return s;
	}

	private boolean isGood(Stack<Long> stack, long one, int M) {
		long MASK = 0x00000001;
		for (int i = 0; i < M; i++) {
			long x = one & MASK;
			one >>= 1;
			if (!stack.isEmpty()) {
				if (stack.peek() == 0 && x == 1) // 只能左括号开头
					stack.pop();
				else
					stack.push(x);
			} else
				stack.push(x);
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	
	/*
	 * 2. 根据提示怎么使用 回溯 ？ backtracking 
	 * 过程思考：对于当前字符串 分别加上 "(",")"就行构造，如果发现失衡（左后括号不匹配）就停止递归（剪枝）
	 * 如果 left > right说明先出现了")" 显然不合理
	 */
	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<String>();
		if(n <= 0)
			return res;
		String soFar = "";
		parenHelper(res, soFar, n, n);
		return res;
	}
	
	
	private void parenHelper(List<String> res, String soFar, int left, int right) {
		if(left > right || left < 0 || right < 0)
			return;
		if(left == 0 && right == 0){
			res.add(soFar);
			return;
		}
		
		parenHelper(res, soFar + "(", left-1, right);
		parenHelper(res, soFar + ")", left, right-1);
	}

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		System.out.println(a.generateParenthesis2(3));
		System.out.println("=======================");
		Stack<Long> stack = new Stack<Long>();
		System.out.println(a.isGood(stack, 5, 4));
		System.out.println(a.getParenthesisFromLong(42, 6));
	}
}
