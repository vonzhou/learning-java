package oj.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraverseBinaryTree {
	
	public void levelTraverse(BinaryTreeNode tree){
		if(tree == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()){
			BinaryTreeNode tmp = queue.remove();
			System.out.print(tmp.val + " ");
			if(tmp.left != null)
				queue.add(tmp.left);
			if(tmp.right != null)
				queue.add(tmp.right);
		}
	}

}
