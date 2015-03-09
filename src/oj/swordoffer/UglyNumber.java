package oj.swordoffer;

public class UglyNumber {
	/*
	 * 1.brute 
	 */
	public boolean isUgly(int n){
		while(n%2 == 0)
			n/=2;
		while(n%3 == 0)
			n/=3;
		while(n%5 == 0)
			n/=5;
		
		return n==1;
	}
	
	public int getUglyNumber(int index){
		if(index <= 0)
			return 0;
		int number = 0;
		int count = 0;
		while(count < index){
			++number;
			if(isUgly(number))
				count ++;
		}
		
		return number;
	}
	
	/*
	 * 2. 不变量是已得的丑数 然后分别X2,3,5取最小的  以空间换时间
	 */
	public int getUglyNumber2(int index){
		if(index <= 0)
			return 0;
		int number = 0;
		int[] uglys = new int[index];
		uglys[0] = 1; // first ugly number is 1
		int p2 = 0, p3 = 0, p5 = 0;
		int next = 1;
		while(next < index){
			int min = Math.min(uglys[p2] * 2, uglys[p3] * 3);
			min = Math.min(uglys[p5] * 5, min);
			uglys[next] = min;
			
			while(uglys[p2] *2 <= min)
				p2++;
			while(uglys[p3] *3 <= min)
				p3++;
			while(uglys[p5] *5 <= min)
				p5++;
			
			next ++;
		}
		
		int ugly = uglys[index - 1];
		uglys = null;
		return ugly;
	}
	
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		//System.out.println(un.getUglyNumber(10));
		System.out.println(un.getUglyNumber2(100));
	}
	
	
	
	
}
