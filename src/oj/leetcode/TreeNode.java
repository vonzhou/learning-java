package oj.leetcode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
	
	@Override
	public String toString() {
		return val + "";
	}
}
