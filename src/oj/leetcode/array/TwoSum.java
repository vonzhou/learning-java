package oj.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 * Given an array of integers, find two numbers such that they add up
 *  to a specific target number.
 *  The function twoSum should return indices of the two numbers 
 *  such that they add up to the target, where index1 must be less than index2. 
 *  Please note that your returned answers (both index1 and index2) are not zero-based.
 *  
 *  You may assume that each input would have exactly one solution.
 *  Input: numbers={2, 7, 11, 15}, target=9
 *  Output: index1=1, index2=2
 *  
 *  
 */
public class TwoSum {
	//1. 最自然的方法   O(n^2)
	public int[] twoSum1(int[] numbers, int target) {
		if(numbers == null || numbers.length <= 1)
			return null;
		int idx1=0,idx2=0;
		labelA:// 指定标签，跳出最外层循环
			for(idx1 = 0; idx1 < numbers.length-1; idx1++)
				for(idx2 = idx1 + 1; idx2 < numbers.length; idx2 ++){
					if((numbers[idx1] + numbers[idx2]) == target)
						break labelA;
					}
		
		if(idx2 >= numbers.length)
			return null;
		
		return new int[]{idx1+1,idx2+1};
	}
	
	// 2. 换一个角度看问题，遍历到x，看sum - x 是否存在，就会想到利用哈希表
	//特别注意的是处理重复元素的情况，所以不能先全部hash进去，再查找，而是动态判定
	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length <= 1)
			return null;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(numbers[i])){
				int a = map.get(numbers[i])+1;
				int b = i + 1;
				return new int[]{a, b};
			}else{
				map.put(target - numbers[i], i);
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// 测试Map中对重复元素的处理
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1, 100);
		map.put(1, 1000);
		map.put(3, 400);
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
	}
	
	
	
}


















