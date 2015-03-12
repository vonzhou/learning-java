package oj.swordoffer;

import java.util.Stack;



public class BinaryTreeInorderIterative {
	
	public void inorder(BinaryTreeNode root){
		if(root == null)
			return ;
		BinaryTreeNode p = root;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>(); 
				
		while(true){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			if(stack.isEmpty())
				break;
			else {
				BinaryTreeNode tmp = stack.pop();
				System.out.print(tmp.val + " ");
				p = p.right;
			}
			
		}
	}

}
