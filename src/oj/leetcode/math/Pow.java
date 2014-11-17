package oj.leetcode.math;

/*
 * Implement pow(x, n).
 * 
 */
public class Pow {
	/*
	 * native way ..., recursive is worse
	 * cannot AC : Time Limit Exceeded
	 */
	public double pow1(double x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		double res = 1;
		for(int i = 1; i <= n; i++){
			res *= x;
		}
		return res;
	}
	
	/*
	 * corresponding recursive way
	 */
	public double pow2(double x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
	
		return x * pow(x,n-1);
	}
	
	/*
	 * accelerate the step 
	 * notice the negative case .....
	 */
	public double pow(double x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
	
		//int baseSymbol = x > 0 ? 1:-1;
		int indexSymbol = n > 0 ? 1:-1;
		n = n * indexSymbol;
		
		double res = powIgnoreNegative(x,n);
		if(indexSymbol == -1)
			res = 1.0 / res;
		
		return res;
	}

	private double powIgnoreNegative(double x, int n) {
		if(n == 0)
			return 1;
		double half = powIgnoreNegative(x, n/2);
		int flag = n%2;
		if(flag == 0){ // n is even
			return half * half;
		}else
			return half * half * x;
	}
	
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.pow(-2,-3));
		System.out.println(p.pow(-2,2));
	}
	
	
}















