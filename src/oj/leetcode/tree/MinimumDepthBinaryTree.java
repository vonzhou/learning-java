package oj.leetcode.tree;


/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 * 注意这里的定义：是到叶节点的最短距离，所以{1,3}应该输出2 而不是1
 * 
 * 相关问题   -- MaxDepthBinaryTree
 */
public class MinimumDepthBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0; 
		return getDepth(root);
	}
	public int getDepth(TreeNode root) {
		if (root == null)
			return Integer.MAX_VALUE; // 注意这里
		if(root.left == null && root.right == null)
			return 1;
		
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		return Math.min(left, right) + 1;
	}
}
