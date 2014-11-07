package oj.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].   说明从第0层开始 
 *
 *Note:
 *Could you optimize your algorithm to use only O(k) extra space?
 *相关题目：Pascal's Triangle
 */

public class PascalTriangleII {
	
	// 1.一层层迭代，但是复杂度很高
	public List<Integer> getRow1(int rowIndex) {
		if(rowIndex < 0)
			return null;
		List<List<Integer>> res = generate(rowIndex + 1);
		return res.get(rowIndex);
	}
	public List<List<Integer>> generate(int numRows) {  
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> level = null;
		if(numRows <= 0)
			return res; // 注意这里 返回的是空集合，而不是null
		
		//first level
		level = new ArrayList<Integer>();
		level.add(1);
		res.add(level);
		
		for(int i = 2; i <= numRows; i++){
			List<Integer> pre = res.get(i - 2);//注意这里
			
			//first 1
			level = new ArrayList<Integer>();
			level.add(1);
			
			for(int j = 0; j < pre.size() -1; j++){
				level.add(pre.get(j) + pre.get(j + 1));
			}
			
			//last 1
			level.add(1);
			res.add(level);
		}
		
		return res;
	}
	
	// 2. 其实上述迭代的过程已经说明了过程，只需要达到第k层，前面的过程不重要，所以可以覆盖
	public List<Integer> getRow(int rowIndex) {
		if(rowIndex < 0)
			return null;
		
		int num[] = new int[rowIndex + 1];// O(n)复杂度
		
		// 每一轮从后往前覆盖
		for(int i = 0; i <= rowIndex; i++){
			num[i] = 1;
			num[0] = 1;
			for(int j = i-1; j > 0; j--)
				num[j] = num[j-1] + num[j];
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i < num.length; i++)
			res.add(num[i]);
		return res;
	}
	
	
	
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		System.out.println(pt.getRow(0));
	}
	
	
}
