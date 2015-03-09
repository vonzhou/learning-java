package oj.swordoffer;



public class TreeDepth {
	
	/*
	 * 使用递归很简单 
	 * 其实可以在树节点中增加字段size 保存其大小  这样就可以直接获得
	 */
	public int depth(BinaryTreeNode root){
		if(root == null)
			return 0;
		int nleft = depth(root.left);
		int nright = depth(root.right);
		
		return (nleft > nright) ? (nleft+1) : (nright+1);
	}

}
