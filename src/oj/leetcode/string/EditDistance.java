package oj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two words word1 and word2, find the minimum number of steps required 
 * to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * 
 */
public class EditDistance {

	/***********************************************************
	 * 1.看清楚子问题的形成 1)把A[0]替换为B[0]如果二者不同的话，然后求editDistance(A[1..n], B[1...m])
	 * 2)把A[0]删除 然后求editDistance(A[1..n], B[0...m]) 3)在A中头插如B[0]
	 * 然后求editDistance(A[1..n], B[0...m]) 去上面的最小值，递归的终止条件是A或B为空为止
	 * 
	 * NB. Status: Time Limit Exceeded
	 */
	public int minDistanceBrute(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 == null || word1.isEmpty())
			return word2.length();
		if (word2 == null || word2.isEmpty())
			return word1.length();

		int replaceCase = minDistance(word1.substring(1), word2.substring(1))
				+ replaceCost(word1, word2, 0, 0);
		int deleteCase = minDistance(word1.substring(1), word2) + 1;
		int insertCase = minDistance(word1.substring(1), word2) + 1;

		return min(replaceCase, deleteCase, insertCase);
	}

	

	/*****************************************************
	 * 2. 自顶向下的动态规划
	 * 同样发生了超时
	 */

	public int minDistanceDPTopDown(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		return minDistance(word1, word2, new HashMap<StringTuple, Integer>());
	}

	private int minDistance(String word1, String word2,
			Map<StringTuple, Integer> computedSolutions) {
		if (word1.isEmpty())
			return word2.length();
		if (word2.isEmpty())
			return word1.length();

		StringTuple replaceTuple = new StringTuple(word1.substring(1),
				word2.substring(1));
		StringTuple deleteTuple = new StringTuple(word1.substring(1), word2);
		StringTuple insertTuple = new StringTuple(word1, word2.substring(1));

		int replace = replaceCost(word1, word2,0 ,0)
				+ transformationCost(replaceTuple, computedSolutions);
		int delete = 1 + transformationCost(deleteTuple, computedSolutions);
		int insert = 1 + transformationCost(insertTuple, computedSolutions);

		int res = min(replace, delete, insert);
		computedSolutions.put(new StringTuple(word1, word2), res);
		return res;
	}

	private int transformationCost(StringTuple tuple,
			Map<StringTuple, Integer> solutions) {
		if (solutions.containsKey(tuple))
			return solutions.get(tuple);

		int result = minDistance(tuple.s1, tuple.s2, solutions);
		solutions.put(tuple, result);
		return result;
	}

	/**
	 * 现在的每一步是有两个string进行的 所以构造一个辅助类 将tuple(s1,s2)作为Map的key
	 *
	 */
	private class StringTuple {
		private final String s1;
		private final String s2;

		public StringTuple(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public int hashCode() {
			return s1.hashCode() ^ s2.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof StringTuple))
				return false;
			StringTuple an = (StringTuple) obj;
			return this.s1.equals(an.s2) && this.s2.equals(an.s1);
		}
	}
	

	private int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	/*******************************************
	 * 3.
	 */
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 == null || word1.isEmpty())
			return word2.length();
		if (word2 == null || word2.isEmpty())
			return word1.length();
		int m = word1.length();
		int n = word2.length();

	    // Cost[i][j]表示words1.substr(0, i)到 words2.substr(0, j) 的最短编辑距离
	    int[][] Cost= new int[m+1][n+1];
	    // 初始化边界情况
	    for (int i = 0; i <= m; ++i) 
	    	Cost[i][0] = i;
	    for (int j = 0; j <= n; ++j) 
	    	Cost[0][j] = j;
	    
	    // 由A[0...i]到B[0...j]的最短距离分为三种情况
	    for (int i = 1; i <= m; ++i) {
	        for (int j = 1; j <= n; ++j) {
	        	int insertBoth = Cost[i-1][j-1] + replaceCost(word1, word2,0,0);
	        	int insertA = Cost[i-1][j] + 1;
	        	int insertB = Cost[i][j-1] + 1;
	            Cost[i][j] = Math.min(Math.min(insertA, insertB), insertBoth);
	        }
	    }

	    return Cost[m][n];
	  }
	private int replaceCost(String word1, String word2, int i1, int i2) {
		return word1.charAt(i1) == word2.charAt(i2) ? 0 : 1;
	}
	
	
	/***************************************
	 * TEST:
	 */

	public static void main(String[] args) {
		String s1 = "sea", s2 = "eat";
		int res = new EditDistance().minDistance(s1, s2);
		System.out.println(res);
	}
}
