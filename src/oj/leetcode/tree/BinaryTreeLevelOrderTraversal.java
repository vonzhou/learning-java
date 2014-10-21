package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Given a binary tree, return the level order traversal of its 
 * nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
  return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
/*
 * 层序遍历是用队列
 * 每一层的界限如何决定？就是对每层如何计数(！！！通过当前队列的长度决定)
 */
public class BinaryTreeLevelOrderTraversal {
	  public List<List<Integer>> levelOrder(TreeNode root) {
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
		  List<Integer> level ; // deal with every level
		  
		  if(root == null)
			  return res;  // 要求空的时候返回 "[]"而不是null
		  
		  queue.offer(root);
		  while(!queue.isEmpty()){
			  level = new ArrayList<Integer>();
			  // 每一层的时候求一次大小，而不是在处理的过程中，错误for(int i = 0; i < queue.size(); i++)
			  int size = queue.size();
			  for(int i = 0; i < size; i++){
				  TreeNode cur = queue.remove();
				  //Retrieves and removes the head of this queue.
				  //This method differs from poll only in that it throws an 
				  //exception if this queue is empty.

				  if(cur.left != null)
					  queue.add(cur.left);
				  if(cur.right != null)
					  queue.add(cur.right);
				  level.add(cur.val);
			  }
			  
			  res.add(level); // get one level iterated
		  }
		  
		  return res;
	  }      
}








