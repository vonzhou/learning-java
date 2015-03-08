package oj.swordoffer;



public class ConvertBinarySearchTree {
	public BinaryTreeNode convert(BinaryTreeNode root){
		BinaryTreeNode lastNode = null;
		convertNode(root, lastNode);
		
		// the lastNode point to the list tail , so shift it
		while(lastNode != null && lastNode.left != null)
			lastNode = lastNode.left;
		
		return lastNode;
	}
	
	public void convertNode(BinaryTreeNode root, BinaryTreeNode lastNode) {
		if(root == null)
			return;
		
		BinaryTreeNode currentNode = root;
		if(currentNode.left != null)
			convertNode(currentNode.left, lastNode);
		
		currentNode.left = lastNode;
		if(lastNode != null)
			lastNode.right = currentNode;
		
		lastNode = currentNode;
		if(currentNode.right != null)
			convertNode(currentNode.right, lastNode);
	}

	public static void func(BinaryTreeNode node){
		node.val = 100;
		System.out.println("in func : " + node.val);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(1);
		func(tree);
		System.out.println("in main : " + tree.val);
	}

}
