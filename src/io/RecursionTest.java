package io;

public class RecursionTest {
	//使用递归计算阶乘
	public int f(int num){
		if(1==num){//	递归的出口 
			return 1;
			}
		return num*f(num-1);
	}
	
	//使用递归计算斐波那契数列
	public int fab(int num){
		if(num==1||2==num){
			return 1;
		}
		return fab(num-1)+fab(num-2);
	}
	
	public static void main(String[] args) {
		System.out.println(new RecursionTest().f(5));
		
		System.out.println(new RecursionTest().fab(9));
	}

}
