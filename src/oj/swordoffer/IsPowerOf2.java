package oj.swordoffer;


/*
 * 任然是利用 n & (n-1) 消除整数最右边的1  ，2^N 中只有一个位为1
 */
public class IsPowerOf2 {
	public static int isPowerOf2(int n){
		if(n <= 0)
			return 0;
		
		int res = n & (n - 1);
		
		return res==0 ? 1 : 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(-32));
	}
}
