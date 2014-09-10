package thinkinginjava.arrays;

import java.util.Arrays;

public class Ex2 {
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static BerylliumSphere[] someSpheres(int n) {
		BerylliumSphere[] result = new BerylliumSphere[n];
		for (int i = 0; i < n; i++)
			result[i] = new BerylliumSphere();
		return result;
	}

	public static void main(String[] args) {
		print(Arrays.asList(someSpheres(3)));
	}
}
