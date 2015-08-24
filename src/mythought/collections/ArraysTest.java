package mythought.collections;

import java.util.Arrays;

public class ArraysTest {
	
	public static void main(String[] args) {
		int[] a = {1,56,8,3,9,6};
		Arrays.sort(a);
		
		int res = Arrays.binarySearch(a, 6);
		System.out.println(res);
		res = Arrays.binarySearch(a, 2);
		System.out.println(res);
	}

}
