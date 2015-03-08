package oj.swordoffer;

public class MirrorOfBinaryTree {
	
	public void mirrorRecursively(BinaryTreeNode tree){
		if(tree == null)
			return;
		if(tree.left == null && tree.right == null)
			return ;
		
		BinaryTreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		
		mirrorRecursively(tree.left);
		mirrorRecursively(tree.right);
	}
	
	// ∑«µ›πÈ µœ÷ ???
	public void mirrorTree(BinaryTreeNode tree){
	}

}
