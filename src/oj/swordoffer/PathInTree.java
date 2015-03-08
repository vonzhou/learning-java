package oj.swordoffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PathInTree {
	
	public void findPath(BinaryTreeNode root, int expectedSum){
		if(root == null)
			return;
		ArrayDeque<Integer> path = new ArrayDeque<Integer>();
		int currentSum = 0;
		findPath(root, expectedSum, path, currentSum);
	}

	public void findPath(BinaryTreeNode root, int expectedSum,
			Deque<Integer> path, int currentSum) {
		currentSum += root.val;
		path.add(root.val);
		
		boolean isLeaf = root.left==null && root.right == null;
		if(currentSum == expectedSum && isLeaf){
			// path found .....
			System.out.print("Found a path: ");
			Iterator<Integer> iter = path.iterator();
			while(iter.hasNext()){
				System.out.print(iter.next() + "  ");
			}
			System.out.println();
		}
		
		if(root.left != null)
			findPath(root.left, expectedSum, path, currentSum);
		if(root.right != null)
			findPath(root.right, expectedSum, path, currentSum);
		
		// backtracking ??
		currentSum -= root.val;
		path.removeLast();
	}
	
	public static void main(String[] args) {
		
	}

}
