package oj.swordoffer;

import java.util.Arrays;

public class DicesProbability {
	public static final int MAX_DICE = 6;
	
	
	/*
	 * 1. 通过递归  拿第i个骰子和剩下的n-1个进行组合 一次类推
	 * 这个递归的过程画出来应该是一颗6叉树
	 */
	public void printProbability(int N){
		if(N < 1)
			return ;
		int maxsum = N * MAX_DICE;
		// 每种点数之和出现的次数统计数组
		int[] frequency = new int[maxsum - N + 1];
		
		probabilityCore(N, frequency);
		int denominator =  (int)Math.pow((double)MAX_DICE, (double)N);
		System.out.println(Arrays.toString(frequency));
		for(int i=N; i<=maxsum; i++){
			double ratio = ((double)frequency[i-N])/denominator;
			System.out.println("Sum: "+ i +", Ratio: " + ratio);
		}
		
		frequency = null;
	}

	public  void probabilityCore(int N, int[] frequency) {
		// 把i放在下一次递归的时候加上
		for(int i=1; i<=MAX_DICE; i++)
			probabilityCore(N, i, N, 0, frequency);
	}

	public void probabilityCore(int N, int curDiceVal, int numOfDices, int curSum, int[] frequency) {
		if(numOfDices == 1){
			int sum = curDiceVal + curSum;
			frequency[sum-N] ++;
		}else{
			int sum = curDiceVal + curSum;
			for(int i=1; i<=MAX_DICE; i++)
				probabilityCore(N, i, numOfDices-1, sum, frequency);
		}
	}
	
	
	/*
	 * 2.重要：动态规划
	 * 在有k-1个骰子的基础上，再增加一个骰子，这个骰子的点数只可能为1-6。
	 * 那k个骰子得到点数和为n的情况有：k-1骰子的和为n-1加上此次的1，k-1骰子的和为n-2加上此次的2，依次类推；
	 * 表示为：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
	 * 越界的f(k,n)= 0;
	 * 初始化：有1个骰子时，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。 
     */  
	public void printProbability3(int N){
		if(N < 1)
			return ;
		int maxsum = N * MAX_DICE;
		// not use row=0,col=0
		int[][] f= new int[N+1][maxsum + 1];
		
		for(int i=1; i<=MAX_DICE; i++)
			f[1][i] = 1;
		
		for(int i=2; i<=N; i++){
			// 考虑所有可能会出现和
			for(int s= N; s<=maxsum; s++){
				for(int j=1; s-j>=1 && j<=MAX_DICE; j++){
					//System.out.println("i:" + i + "s:" + s + " j: "+j);
					f[i][s] += f[i-1][s-j];
				}
			}
		}
		
		int denominator =  (int)Math.pow((double)MAX_DICE, (double)N);
		for(int i=N; i<=maxsum; i++){
			double ratio = ((double)f[N][i])/denominator;
			System.out.println("Sum: "+ i +", Ratio: " + ratio);
		}
		
		f = null;
	}
	
	
	public static void main(String[] args) {
		int n = 2;
		DicesProbability d = new DicesProbability();
		//d.printProbability(n);
		System.out.println("---------------");
		d.printProbability3(n);
	}

}
