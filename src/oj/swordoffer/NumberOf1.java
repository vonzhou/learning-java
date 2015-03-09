package oj.swordoffer;

public class NumberOf1 {
	
	/*
	 * 1. 最直观的方法是一次遍历 统计每个整数中1的个数 O(nlgn)
	 */
	public int numberOf1From1ToN(int n){
		int sum = 0;
		for(int i=1; i<=n; i++)
			sum += number1InN(i);
		return sum;
	}

	public int number1InN(int n) {
		int count = 0;
		while(n!=0){
			if(n % 10 == 1)
				count ++;
			n /= 10;
		}
		return count;
	}
	
	/*
	 *  第二个方法： 规律， 以34105这个数字为例：
	 *  首先最高位是3，出现1的次数： 10000~19999共10000个
	 *  再看次高位是4，出现1的次数：1000~1999，11000~11999，21000-21999，31000~31999，共有3*1000+1000个
	 *  再看第三位是1，出现1的次数：100~199，1100~1199，2100~2199，……34100~34105，共有34*100+6个
	 *  再看第四位是0，出现1的次数：10~19，110~119，210~219……，34010~34019，共有341*10个
	 *  最后一位是个5，出现1的次数：共有3410*1+1
	 *  根据上述分析，总结第n位（从左向右数）出现1的规律可以表述如下：
	 *   第0~n -1位组成的数字乘以跨度（如上述例子，最高位跨度10000，次高位跨度1000），然后再根据当前位是大于1，等于1，
	 *   等于0来加上一个可变的数值。具体点就是，若当前位大于1，则加上跨度；若当前位等于1，则加上该位之后的尾数；若当前位等于0，则加0
	 *   ；具体在个位上时有些许不同。
	 */
	//整数的位数
	public int digitsN(int n){
	    int k = 0; 
	    for(int m = n; m != 0; m /=10)
	        k ++;
	    return k;
	}
	//获得n的第k位数字 , 如1234 第0位是1，第3位是4
	public int  kthDigit(int n, int k)	{
	    int num = digitsN(n);
	    if(k < 0 || k > (num-1))
	        return 0;
	    int res = ((int)(n/Math.pow(10,num-k-1)));
	    return res % 10 ;
	}
	
	public int numberOf1From1ToN2(int n)
	{
	    //digits of n
	    int num = digitsN(n);
	    int scale = (int)Math.pow(10, num-1);
	    int factor = 0;
	    int remainder = 0;
	    
	    int digit = 0;
	    int count = 0; 

	    for(int k = 0; k < num; k++)
	    {
	        count += factor * scale;
	        digit = kthDigit(n,k);
	        if(digit > 1)
	            count += scale;
	        else if(digit == 1)
	        {
	        	// 个位是1
	            if(k == num-1)
	                remainder = 1;
	            else
	                remainder = n % scale + 1;
	            
	            count += remainder;
	        }
	        
	        factor = (int)(n/scale);
	        scale /= 10;
	    }
	    return count;
	}
	
	
	/*
	 * 3. 开放问题 ：把数字组合成字符串  从而统计其中字符1出现的字数   空间开销很大  ??
	 */
	
	
	public static void main(String[] args) {
		NumberOf1 test = new NumberOf1();
		//System.out.println(test.number1InN(111));
		System.out.println(test.numberOf1From1ToN(4));
		System.out.println(test.numberOf1From1ToN2(4));
		//System.out.println(test.kthDigit(1234, 3));
	}

}
