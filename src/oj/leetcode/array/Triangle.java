package oj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, 
 where n is the total number of rows in the triangle.

 * 1. 题的意思没有理解  对adjacent理解
 * 2. 和二维矩阵中最小路径类型  空间复杂度是 O(n^2)
 * 3. 
 *
 */
public class Triangle {

	// 1. 错误的理解
	public int minimumTotal1(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;//
		int size = triangle.size();
		List<Integer> mins = new ArrayList<Integer>(size);
		// iterate this list of lists
		for (List<Integer> list : triangle) {
			if (list == null || list.size() == 0)
				continue;
			int min = list.get(0);
			for (Integer x : list) {
				if (x < min)
					min = x;
			}
			mins.add(min);
		}

		int total = 0;
		for (int x : mins)
			total += x;

		return total;
	}

	// 直观的想法， 想象是一棵树，两个高层节点决定下一个节点的路径长度 动态规划
	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;//
		// 如何实现LIst的深度拷贝??TODO
		int size = triangle.size();
		int[][] paths = new int[size][size];
		paths[0][0] = triangle.get(0).get(0);
		// 边界处理
		for (int i = 1; i < size; i++) {
			int levelSize = triangle.get(i).size();
			paths[i][0] = triangle.get(i).get(0) + paths[i - 1][0];
			paths[i][i] = triangle.get(i).get(i) + paths[i - 1][i - 1];

		}

		// 更新其他路径
		for (int i = 2; i < size; i++)
			for (int j = 1; j < i; j++) {
				paths[i][j] = triangle.get(i).get(j)
						+ Math.min(paths[i - 1][j - 1], paths[i - 1][j]);
			}

		int min = paths[size - 1][0];
		for (int i = 0; i < size; i++)
			if (paths[size - 1][i] < min)
				min = paths[size - 1][i];

		return min;
	}

	// 动态规划  自底向上 达到O(n)的空间复杂度 n代表层数
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;//
		
		int size = triangle.size();
		int[] paths = new int[size];
		List<Integer> lastList = triangle.get(size-1);
		
		// last level list size is size
		for(int i = 0; i < size; i++)
			paths[i] = lastList.get(i);
		
		for(int i = size-2; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				paths[j] = triangle.get(i).get(j) +
						Math.min(paths[j], paths[j+1]);
			}
		}
	

		return paths[0];
	}
}
