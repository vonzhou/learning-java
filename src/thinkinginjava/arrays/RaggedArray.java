//: arrays/RaggedArray.java
package thinkinginjava.arrays;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {
	public static void main(String[] args) {
		int d1 = 0, d2 = 0, d3 = 0;
		Random rand = new Random(47);
		// 3-D array with varied-length vectors:
		d1 = rand.nextInt(7);
		int[][][] a = new int[d1][][];
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			d2 = rand.nextInt(5);
			a[i] = new int[d2][];
			for (int j = 0; j < a[i].length; j++) {
				d3 = rand.nextInt(5);
				a[i][j] = new int[d3];
			}
		}
		System.out.println(d1 + " " + d2 + " " + d3);
		System.out.println(Arrays.deepToString(a));
	}
}
