package oj.swordoffer;

public class TwoNumAppearOnce {
	
	public int[] findTwo(int[] data, int len){
		if(data == null || len < 2)
			return null;
		int twoExclusive = 0;
		for(int i=0; i<len; i++)
			twoExclusive ^= data[i];
		int index1 = first1(twoExclusive); //
		
		int[] res = new int[2];
		for(int i=0; i<len; i++){
			if(isBit1(data[i], index1))
				res[0] ^= data[i];
			else res[1] ^= data[i];
		}
		
		return res;
	}

	private boolean isBit1(int num, int k) {
		num = num >> k;
		return (num & 1)==1;
	}

	private int first1(int num) {
		int p = 0;
		int BITS = Integer.SIZE * 8;
		while(((num & 1) == 0) && p < BITS){
			num = num >>1;
			p++;
		}
		return p;
	}
	
	public static void main(String[] args) {
		TwoNumAppearOnce t = new TwoNumAppearOnce();
		int[] a = {2,4,3,6,3,2,5,5};
		int[] res = t.findTwo(a, a.length);
		System.out.println(res[0] + "," + res[1]);
	}
}















