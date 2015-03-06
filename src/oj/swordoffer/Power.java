package oj.swordoffer;


public class Power {
	
	/*
	 * 直观的思路，但是要考虑全面 指数为负的情况
	 */
	public static double power(double base, int exponent) throws Exception{
		if(doubleEqual(base, 0.0) && exponent < 0){
			// invalid input 
			throw new Exception("invalid input");
		}
		int absExponent = exponent;
		if(exponent < 0)
			absExponent = -exponent;
		double res = powerWithPositiveExponent2(base, absExponent);
		if(exponent < 0)
			res = 1.0/res;
		
		return res;
	}
	
	public static double powerWithPositiveExponent(double base, int exponent) {
		double res = 1.0;
		for(int i=1;i<=exponent;i++)
			res *= base;
		
		return res;
	}
	
	public static double powerWithPositiveExponent2(double base, int exponent) {
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		
		double res = powerWithPositiveExponent2(base, exponent >> 1);
		res *= res;
		// is odd
		if((exponent & 0x01) == 1)
			res *= base;
		
		return res;
	}

	public static boolean doubleEqual(double d1, double d2) {
		// ======= Double.compare(d1, d2); 
		if((d1 - d2 > -0.0000001) &&(d1-d2 < 0.0000001))
				return true;
		return false;
	}

	public static void main(String[] args) throws Exception{
		System.out.println(power(2,5));
		System.out.println(power(2,-5));
		System.out.println(power(0,0));
		//System.out.println(power(0,-2));
	}

}
