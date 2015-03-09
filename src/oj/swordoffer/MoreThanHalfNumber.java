package oj.swordoffer;

import java.util.Arrays;


/*
 * 1. 先进行排序  在统计次数  O(nlgn)
 * 2. 找数字的任意第k大的数字  O(n)
 * 3. 对数字计数   
 */
public class MoreThanHalfNumber {
	
	/*
	 * ************2********************
	 */
	public int moreThanHalf(int[] numbers, int len){
		if(numbers==null || len <= 0)
			return -999;  // invalid input
		
		int mid = len >> 1;
		int start = 0;
		int end = len - 1;
		int index = partition(numbers, len, start, end);
		while(index != mid){
			if(index > mid){
				end = index - 1;
				index = partition(numbers, len, start, end);
			}else{
				start = index + 1;
				index = partition(numbers, len, start, end);
			}
		}
		
		int res = numbers[mid];
		if(!checkMoreThanHalf(numbers,len,res))
			res = -999;
		
		return res;
	}
	
	public boolean checkMoreThanHalf(int[] numbers, int len, int x) {
		// ......
		return true;
	}

	public int partition(int[] data, int len, int start, int end){
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
		//System.out.println(Arrays.toString(data));
		return small;
	}

	public void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	/*
	 * ************3********************
	 */
	public int moreThanHalf2(int[] numbers, int len){
		if(numbers==null || len <= 0)
			return -999;  // invalid input
		
		int res = numbers[0];
		int times = 1;
		for(int i=1; i<len; i++){
			if(times == 0){
				res = numbers[i];
				times = 1;
			}else if(numbers[i] == res)
				times ++;
			else times --;
		}
		if(!checkMoreThanHalf(numbers,len,res))
			res = -999;
		
		return res;
	}
	
	public static void main(String[] args) {
		MoreThanHalfNumber m = new MoreThanHalfNumber();
		int[] a = {1,2,3,2,2,2,5,4,2};
		System.out.println(m.moreThanHalf(a, a.length));
		System.out.println(m.moreThanHalf2(a, a.length));
	}
	

}
