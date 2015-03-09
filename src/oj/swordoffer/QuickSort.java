package oj.swordoffer;

import java.util.Arrays;

public class QuickSort {

	public int partion(int[] data, int len, int start, int end){
		if(data == null || len <= 0 || start < 0 || end >= len)
			return -1;  
		int index = end; //randomInRange(start, end);
		swap(data, index, end);
		
		int small = start -1;
		for(index =start; index<end;index++){
			if(data[index] < data[end]){
				++small;
				if(small != index)
					swap(data, index, small);
				
			}
		}
		
		++small;
		swap(data, small, end);
		System.out.println(Arrays.toString(data));
		return small;
	}

	public void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = {1,3,2,9,5,12,45,22,7};
		int index = qs.partion(a, a.length, 0, a.length-1);
		System.out.println(index);
 	}

}
