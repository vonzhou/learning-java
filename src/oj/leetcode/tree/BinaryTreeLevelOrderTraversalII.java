package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 *  For example:
 *  Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
/*
 * 和上一个题不同的是，这里要自底向上的方式，只需要构造链表的方式改变即可
 */
public class BinaryTreeLevelOrderTraversalII {
	  public List<List<Integer>> levelOrderBottom(TreeNode root) {
		  
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  // 采用链表，头插法实现倒序
		  List<List<Integer>> res = new LinkedList<List<Integer>>();  
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
			  res.add(0, level); // 注意这里
		  }
		  
		  return res;
	  }      
}








