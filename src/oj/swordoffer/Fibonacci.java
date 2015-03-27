package oj.swordoffer;

public class Fibonacci {
	/*
	 * 1. 直接根据递归公式
	 */
	public static long fibonacciRecur(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacciRecur(n-1) + fibonacciRecur(n-2);
	}
	
	/*
	 * 2. 使用迭代，每一次保存必要的状态信息供下次loop使用
	 * 自底向上 动态规划
	 */
	public static long fibonacciIter(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		long a = 0, b=1;
		long c = 0;
		for(int i=2; i<=n; i++){
			c = a+b;
			a = b;
			b = c;//注意细节
		}
		
		return c;
	}
	
	/*
	 * 3. 存在2X2矩阵A 使得 (Fn,Fn-1) = (Fn-1,Fn-2)*A
	 * 问题可以转化为 求矩阵A的n次方
	 */
	public static long fibonacci3(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int f0=0,f1=1;
		Matrix A =  new Matrix(2, new int[][]{{1,1},{1,0}});
		Matrix pow = Matrix.pow(A, n-1);
		int fn = f1 * pow.data[0][0] + f0 * pow.data[1][0];
		return fn;
	}
	
	
	static class Matrix{
		int n; // Matrix is N X N
		int[][] data;
		public static final Matrix IDENTITY = new Matrix(2, new int[][] {{1,0},{0,1}});
		public Matrix(int n){
			this.n = n;
			data = new int[n][n];
		}
		public Matrix(int n, int[][] arr){
			this.n = n;
			data = arr;
		}
		public Matrix multiply(Matrix that){
			if(this.n != that.n)
				return null;
			//矩阵乘法
			Matrix res = new Matrix(n);
			for(int i=0;i<n; i++){
				for(int j=0; j<n; j++){
					int sum = 0;
					for(int k=0; k<n; k++)
						sum += data[i][k] * that.data[k][j];
					res.data[i][j] = sum;
				}
			}
			
			return res;
		}
		public static Matrix pow(Matrix m, int n){
			Matrix res = IDENTITY;
			Matrix temp = m;
			for(; n!=0; n >>= 1){
				if((n & 0x1) != 0)
					res = res.multiply(temp);
				temp = temp.multiply(temp);
					
			}
			
			return res;
		}
		public void show(){
			for(int i=0;i<n; i++){
				for(int j=0; j<n; j++){
					System.out.print(data[i][j] +" ");
				}
				System.out.println();
			}
		}
		
	} // end class
	
	//my test
	public static int pow(int m, int n){
		int res = 1;
		int temp = m;
		for(; n!=0; n>>=1){
			if((n & 0x1) != 0)
				res *= temp;
			temp *= temp;
		}
		return res;
	}
	
	/**************************************************
	 * Test
	 */
	public static void main(String[] args) {
		//System.out.println(fibonacciRecur(20));
		//System.out.println(pow(2, 10));
		test1();
	}
	
	public static void test1(){
		//Matrix.IDENTITY.show();
		//Matrix res = Matrix.pow(Matrix.IDENTITY, 1);
		//Matrix res = Matrix.IDENTITY.multiply(Matrix.IDENTITY);
		Matrix a = new Matrix(2, new int[][]{{1,1},{1,1}});
		Matrix res = Matrix.pow(a, 10);
		res.show();
		System.out.println("======================");
		int N = 6;
		System.out.println(fibonacciIter(N));
		System.out.println(fibonacci3(N));
		
	}

}
