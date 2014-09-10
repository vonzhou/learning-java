//: arrays/ArrayOptions.java
// Initialization & re-assignment of arrays.
package thinkinginjava.arrays;

import java.util.Arrays;

public class ArrayOptions {
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		// Arrays of objects:
		BerylliumSphere[] a; // Local uninitialized variable
		BerylliumSphere[] b = new BerylliumSphere[5];
		// The references inside the array are automatically initialized to
		// null,如果是基本类型的话就是0
		print("b: " + Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++)
			if (c[i] == null) // Can test for null reference
				c[i] = new BerylliumSphere();
		// Aggregate initialization:
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(),
				new BerylliumSphere() };
		// Dynamic aggregate initialization:
		a = new BerylliumSphere[] { new BerylliumSphere(),
				new BerylliumSphere(), };
		// (Trailing comma is optional in both cases)
		print("a.length = " + a.length);
		print("b.length = " + b.length);
		print("c.length = " + c.length);
		print("d.length = " + d.length);
		a = d;
		print("a.length = " + a.length);

		// Arrays of primitives:
		int[] e; // Null reference
		int[] f = new int[5];
		// The primitives inside the array are
		// automatically initialized to zero:
		print("f: " + Arrays.toString(f));
		int[] g = new int[4];
		for (int i = 0; i < g.length; i++)
			g[i] = i * i;
		int[] h = { 11, 47, 93 };
		// Compile error: variable e not initialized:
		// !print("e.length = " + e.length);
		print("f.length = " + f.length);
		print("g.length = " + g.length);
		print("h.length = " + h.length);
		e = h;
		print("e.length = " + e.length);
		e = new int[] { 1, 2 };
		print("e.length = " + e.length);
	}
}
