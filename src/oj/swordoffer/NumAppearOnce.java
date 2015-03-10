package oj.swordoffer;

public class NumAppearOnce {
	
	public static int find(int[] data, int len){
		if(data == null || len <2)
			return -1;  //....
		
		int res = 0;
		for(int i=0; i<len; i++)
			res ^= data[i];
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,3,5,1,6,6,2};
		System.out.println(find(a, a.length));
	}

}
