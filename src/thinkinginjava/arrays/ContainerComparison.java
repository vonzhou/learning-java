//: arrays/ContainerComparison.java
package thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerylliumSphere {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Sphere " + id;
	}
}

public class ContainerComparison {
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		BerylliumSphere[] spheres = new BerylliumSphere[10];
		// 默认会初始化为0
		for (int i = 0; i < 5; i++)
			spheres[i] = new BerylliumSphere();
		print(Arrays.toString(spheres));
		print(spheres[4]);

		List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
		for (int i = 0; i < 5; i++)
			sphereList.add(new BerylliumSphere());
		print(sphereList);
		print(sphereList.get(4));

		int[] integers = { 0, 1, 2, 3, 4, 5 };
		print(Arrays.toString(integers));
		print(integers[4]);

		// Arrays.asList-Returns a fixed-size list backed by the specified
		// array.
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2,
				3, 4, 5));
		intList.add(97);
		print(intList);
		print(intList.get(4));
	}
}