package oj.leetcode.array;

import java.util.ArrayList;
import java.util.List;


/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class PascalTriangle {
	
	// 1.自己想到的方法
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
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.generate(5));
	}
	
	
}
