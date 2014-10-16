package oj.leetcode;

/*
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {  
	
	// 很容易想到这种方式，但是需要重复遍历
	public  boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right) 
				&& Math.abs(height(root.left) - height(root.right)) <= 1;
	}
	
	public  int height(TreeNode root){
		if(root == null) return 0;
		int ll = 0,rl = 0;
		if(root.left != null)
			ll = height(root.left);
		if(root.right != null)
			rl = height(root.right);
		
		return Math.max(ll, rl) + 1;
	}
	
	// 2.剪枝罚，没看懂
	
	
}
	
	        
		  

