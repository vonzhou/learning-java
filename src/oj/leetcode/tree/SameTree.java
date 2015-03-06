package oj.leetcode.tree;


/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally 
 * identical and the nodes have the same value.
 */
public class SameTree {
	public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null || q == null)
			return false;
		
		boolean cur = p.val == q.val;
		
		cur = cur && isSameTree(p.left, q.left);
		cur = cur && isSameTree(p.right, q.right);
		
		return cur;
	}

}
