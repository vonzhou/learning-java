package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 * 1. 利用递归很简单
 * 2.通常考察的就是把递归转为非递归 ,就是利用栈
 * 
 * 相关题目 ： Binary Tree Preorder Traversal
 */
public class BinaryTreeInorderTraversal {
	// 递归实现
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ll = new ArrayList<Integer>();
		List<Integer> rl = new ArrayList<Integer>();
		//List<Integer> rootl = new ArrayList<Integer>();
		if(root == null)	return ll;//注意这里不是返回null，反则不符合要求
										//在输入为{} 的时候，输出 []
		//rootl.add(root.val);
		
		if(root.left != null) 
			ll = inorderTraversal(root.left);
		if(root.right != null) 
			rl = inorderTraversal(root.right);
		ll.add(root.val);
		
		
		for(int i = 0; i<rl.size();i++)
			ll.add(rl.get(i));
		
		return ll;
	}
	
		// 非递归实现，主要是找到一种迭代模式
		public List<Integer> inorderTraversal2(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			if(root == null) return res;
			
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode foot = root;  // footprint
			// p非空  或者 栈中还有元素 就要继续
			
			while(!stack.isEmpty() || foot != null){
				// go to the left most
				if(foot != null){
					stack.push(foot);
					foot = foot.left;
				}else{
					// stack is not empty , need roll back
					TreeNode mid = stack.pop();
					res.add(mid.val);
					// iterate the right
					foot = mid.right;
				}
			}
			
			return res;
		}
}
