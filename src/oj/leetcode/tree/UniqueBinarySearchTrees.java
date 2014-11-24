package oj.leetcode.tree;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * 
 * 有点排列组合的味道:把节点n插入到已有的（n-1）个节点组成的序列中
 * 1,利用递归容易理解
 * 2.用空间换时间，不见得更快
 */
public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		if(n < 0)
			return 0;
		if(n==0 || n == 1)
			return 1;
		int trees=0;
		
		for(int j=0; j <n; j++){
			trees += numTrees(j) * numTrees(n-1-j);
		}
				
		return trees;
	}
	
	public static int numTrees2(int n) {
		if(n < 0)
			return 0;
		if(n==0 || n == 1)
			return 1;
		int tree[] = new int[n+1];
		tree[0] = tree[1] = 1;
		
		for(int i=2; i <= n; i++){
			tree[i] = 0;
			for(int j=0; j <i; j++){
				tree[i] += tree[j] * numTrees(i-1-j);
			}
		}
		return tree[n];
	}
	
	public static void main(String[] args) {
		System.out.println(numTrees(4));
		System.out.println(numTrees2(4));
	}
}
