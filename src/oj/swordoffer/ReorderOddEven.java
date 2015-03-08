package oj.swordoffer;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class ReorderOddEven {
	
	// two pointers ------
	public static void reorderOddEven(int[] numbers){
		if(numbers == null || numbers.length <= 0)
			return;
		int p1 = 0, p2 = numbers.length-1;
		while(p1 < p2){
			// shift p1 to a odd number
			while(p1<p2 && (numbers[p1] & 0x01)!=0)
				p1 ++;
			// shift p1 to a odd number
			while(p1<p2 && (numbers[p2] & 0x01)==0)
				p2 --;
			if(p1 < p2){
				int tmp = numbers[p1];
				numbers[p1] = numbers[p2];
				numbers[p2] = tmp;
			}
		}
	}
	
	/*************************************************
	 * 更加具有可擴展性的方式
	 */
	/*
	public static void reorder(int[] numbers, Callable<Boolean> func){
		if(numbers == null || numbers.length <= 0)
			return;
		int p1 = 0, p2 = numbers.length-1;
		while(p1 < p2){
			// shift p1 to a odd number
			while(p1<p2 && (numbers[p1] & 0x01)!=0)
				p1 ++;
			// shift p1 to a odd number
			while(p1<p2 && (numbers[p2] & 0x01)==0)
				p2 --;
			if(p1 < p2){
				int tmp = numbers[p1];
				numbers[p1] = numbers[p2];
				numbers[p2] = tmp;
			}
		}
	}
	
	*/
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		reorderOddEven(nums);
		System.out.println(Arrays.toString(nums));
	}

}

class ReorderLogicOddEven implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		return false;// isEven();
	}
	
	public boolean isEven(int n){
		return (n & 1) == 0;
	}
	
}
