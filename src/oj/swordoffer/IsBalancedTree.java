package oj.swordoffer;

public class IsBalancedTree {
	
	
	/*
	 * 1. 利用递归求深度  而后判断
	 */
	public boolean isBalanced(BinaryTreeNode root){
		if(root == null)
			return true;
		int left = depth(root.left);
		int right = depth(root.right);
		
		int dif = left - right;
		if(dif < -1 || dif > 1)
			return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int depth(BinaryTreeNode root){
		if(root == null)
			return 0;
		int nleft = depth(root.left);
		int nright = depth(root.right);
		
		return (nleft > nright) ? (nleft+1) : (nright+1);
	}
	
	/*
	 * 2. 利用后序遍历的思想 访问每个节点一遍  并且维持深度
	 */
	public TreeState isBalancedPostOrder(BinaryTreeNode root){
		if(root == null)
			return new TreeState(true, 0);
		
		TreeState sleft = isBalancedPostOrder(root.left);
		TreeState sright = isBalancedPostOrder(root.right);
		int nleft = sleft.getDepth();
		int nright = sright.getDepth();
		
		if(sleft.isBalanced() && sright.isBalanced()){
			int dif = nleft - nright ;
			if(dif <= 1 || dif >= -1){
				int d = 1 + (nleft > nright ? nleft : nright);
				return new TreeState(true, d);
			}
		}
		
		return new TreeState(false, -1);

	}
}

class TreeState{
	boolean balanced;
	int depth;
	public TreeState(boolean b, int d){
		this.balanced = b;
		this.depth = d;
	}
	public boolean isBalanced() {
		return balanced;
	}
	public void setBalanced(boolean balanced) {
		this.balanced = balanced;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}












