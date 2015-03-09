package oj.swordoffer;

public class GreatestSubarraySum {
	
	/*
	 * 1. brute 得到所有连续字数组的和  O(n^2)
	 */
	
	
	/*
	 * 2. 一次遍历 如果之和小于0 就重新开始累积
	 */
	public int greatestSum(int[] data, int len){
		if(data == null || len <= 0)
			return 0; //  Exception
		int curSum = 0;
		int greatest = 0x80000000;
		for(int i=0; i<len; i++){
			if(curSum <= 0)
				curSum = data[i];
			else 
				curSum += data[i];
			if(curSum >= greatest)
				greatest = curSum;
		}
		
		return greatest;
	}
	
	/*
	 * 3. 上面的思路其实就是动态规划   一般用递归分析 用循环实现(上2)
	 */
	public int greatestSum3(int[] data, int len){
		
		int[] f = new int[len];
		f[0] = data[0];
		
		for(int i=1; i<len; i++){
			if(f[i-1] < 0)
				f[i] = data[i];
			else
				f[i] = f[i-1] + data[i];
		}
		// find the max
		int max = f[0];
		for(int i=0; i<len;i++)
			if(f[i] > max)
				max = f[i];
		return max;
	}
	
	
	public static void main(String[] args) {
		GreatestSubarraySum g = new GreatestSubarraySum();
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(g.greatestSum(a, a.length));
		System.out.println(g.greatestSum3(a, a.length));
		
	}
}
