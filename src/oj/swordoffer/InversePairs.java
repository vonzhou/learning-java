package oj.swordoffer;

import java.util.Arrays;

public class InversePairs {
	
	/*
	 * 1. Brute  , O(n^2)
	 */
	
	
	/*
	 * 2. 利用归并排序的思想进行分解
	 */
	public int inversePairs(int[] data, int len){
		if(data == null || len <= 0)
			return 0;
		int[] aux = Arrays.copyOf(data, len);
		int count = mergeAndCount(data, aux, 0, len-1);
		
		aux = null;
		return count;
	}

	public int mergeAndCount(int[] data, int[] aux, int from, int to) {
		if(from == to){
			aux[from] = data[from];
			return 0;
		}
		
		int len = (to-from)/2;
		int left = mergeAndCount(aux, data, from, from + len);
		int right = mergeAndCount(aux, data, from+len+1, to);
		
		int i = from + len;
		int j = to;
		int indexCopy = to;
		int count = 0;
		while(i>=from && j >= from+len+1){
			if(data[i] > data[j]){
				aux[indexCopy--] = data[i--];
				count += j-from-len;
			}else{
				aux[indexCopy--] = data[j--];
			}
			
		}
		for(;i>=from;i--)
			aux[indexCopy--] = data[i];
		for(;j>=from+len+1;j--)
			aux[indexCopy--] = data[j];
		
		return left+right+count;
	}
	
	public static void main(String[] args) {
		InversePairs ip = new InversePairs();
		int[] a = {7,5,6,4,};
		System.out.println(ip.inversePairs(a, a.length));
	}
	
	

}















