package oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	//递归实现
	public static List<Integer> preorderTraversal(TreeNode root) { 
		List<Integer> ll = new ArrayList<Integer>();
		List<Integer> rl = new ArrayList<Integer>();
		List<Integer> rootl = new ArrayList<Integer>();
		if(root == null)	return rootl;//注意这里不是返回null，反则不符合要求
										//在输入为{} 的时候，输出 []
		rootl.add(root.val);
		
		if(root.left != null) 
			ll = preorderTraversal(root.left);
		if(root.right != null) 
			rl = preorderTraversal(root.right);
		for(int i = 0; i<ll.size();i++)
			rootl.add(ll.get(i));
		for(int i = 0; i<rl.size();i++)
			rootl.add(rl.get(i));
		
		return rootl;
	}
	
	// 利用一个栈来实现
	public static List<Integer> preorderTraversal2(TreeNode root) { 
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> rootl = new ArrayList<Integer>();
		if(root == null) return rootl;
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			rootl.add(node.val);
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
		
		return rootl;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(Arrays.asList(12,45));
		TreeNode root = bt.createBiTreeFromList();
		
		List<Integer> res = preorderTraversal(root);
		System.out.println(res);
	}

}
