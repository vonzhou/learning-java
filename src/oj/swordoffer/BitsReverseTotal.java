package oj.swordoffer;


/*
 * 要改变m的多少位，就是判断m，n有多少位是不同的
 * 所以先异或 然后统计
 */
public class BitsReverseTotal {
	public static int bitsReverseTotal(int m, int n){
		int x = m ^ n;
		
		return NumberOf1InBinary.bit1Number4(x);
	}
	
	public static void main(String[] args) {
		System.out.println(bitsReverseTotal(10, 13));
		System.out.println(bitsReverseTotal(0, -1));
		//System.out.println(Integer.toBinaryString(-1));
	}
}
