package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Unique Binary Search Trees II 
 *Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * 该问题和I的*区别*在于 这里要求把结果集存在链表中 而不仅仅是计数
 * 
 * 
 * 如何利用动态规划？？？？？？
 */
public class UniqueBinarySearchTreesII {
	
	/*
	 * 1. 利用递归自底向上的构建BST
	 */
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (n <= 0) {
			res.add(null);
			return res;
		}
		generate(1, n, res);
		return res;
	}

	private void generate(int from, int to, List<TreeNode> res) {
		if (from > to)
			return;
		if (from == to) {
			TreeNode root = new TreeNode(from);
			res.add(root);
			return;
		}
		for (int i = from; i <= to; i++) {
			List<TreeNode> leftTrees = new ArrayList<TreeNode>();
			generate(from, i - 1, leftTrees);
			
			List<TreeNode> rightTrees = new ArrayList<TreeNode>();
			generate(i + 1, to, rightTrees);
			
			if (leftTrees.size() == 0) {
				for (TreeNode rightRoot : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.right = rightRoot;
					res.add(root);
				}
				continue;
			}

			if (rightTrees.size() == 0) {
				for (TreeNode leftRoot : leftTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftRoot;
					res.add(root);
				}
				continue;
			}

			for (TreeNode leftRoot : leftTrees) {
				for (TreeNode rightRoot : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftRoot;
					root.right = rightRoot;
					res.add(root);
				}
			}
		}

	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
		List<TreeNode> res = test.generateTrees(1);
		// Should traverse the trees ....
		System.out.println(res);// 
		//List<Integer> list = new ArrayList<Integer>();
		//list.add(null);
		//System.out.println();
	}
}
