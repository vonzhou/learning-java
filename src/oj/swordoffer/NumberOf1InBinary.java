package oj.swordoffer;

public class NumberOf1InBinary {
	
	//  original 
	public static int bit1Number1(int n){
		int count = 0;
		while(n != 0){
			if((n & 1) != 0)
				count ++;
			n = n >> 1;
		}
		
		return count;
	}
	
	//  利用逻辑右移  IN  JAVA
	public static int bit1Number2(int n){
		int count = 0;
		while(n != 0){
			if((n & 1) != 0)
				count ++;
			n = n >>> 1;
		}
		
		return count;
	}
	
	//  在上述基础上 控制整数的位数  但是前提是二进制数位知道的   在C里面是平台相关的 ？
	public static int bit1Number1My(int n){
		int count = 0;
		for(int i=0; i < 32;i++){
			if((n & 1) != 0)
				count ++;
			n = n >>> 1;
		}
		
		return count;
	}
	
	// 更吊的方法
	public static int bit1Number4(int n){
		int count = 0;
		while(n!=0){
			count ++;
			n = (n-1) & n; // 消除n最右边的一个1
		}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println(bit1Number1(0x0044));
		//System.out.println(bit1Number1(0x80000000));  // dead loop
		
		/*
		System.out.println(bit1Number2(0x0044));
		System.out.println(bit1Number2(0x80000000));  
		System.out.println("----------------");
		System.out.println(bit1Number1My(0x0044));
		System.out.println(bit1Number1My(0x80000000)); 
		
		
		System.out.println(1<<31);  // = -2147483648
		System.out.println(1<<32);   // =1
		
		System.out.println(bit1Number3(0x0044));
		System.out.println(bit1Number3(0x80000000)); 
		*/
		System.out.println(bit1Number4(100));
		System.out.println(bit1Number4(0x80000000));
		
	}

}
