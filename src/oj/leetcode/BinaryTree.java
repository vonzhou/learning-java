package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	List<Integer> list;
	TreeNode root;
	int size;

	public BinaryTree(List<Integer> list) {
		this.list = list;
		this.size = list.size();
	}

	public TreeNode createBiTreeFromList() {
		int parentIndex = 0;
		// 将这些数字转换为一个个节点
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int i = 0; i < list.size(); i++)
			nodes.add(new TreeNode(list.get(i)));

		int lastParentIndex = nodes.size() / 2 - 1;
		// 根据二叉树的特点将这些节点链接起来
		for (parentIndex = 0; parentIndex < lastParentIndex; parentIndex++) {
			nodes.get(parentIndex).left = nodes.get(2 * parentIndex + 1);
			nodes.get(parentIndex).right = nodes.get(2 * parentIndex + 2);
		}

		// 只需要对最后一个父节点进行特殊考虑
		nodes.get(lastParentIndex).left = nodes.get(2 * lastParentIndex + 1);
		if (nodes.size() % 2 == 1)
			nodes.get(lastParentIndex).right = nodes
					.get(2 * lastParentIndex + 2);

		return nodes.get(0);
	}

}
