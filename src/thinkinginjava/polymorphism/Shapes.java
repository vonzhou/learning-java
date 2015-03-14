package thinkinginjava.polymorphism;

import thinkinginjava.polymorphism.shape.*;

public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		// Fill up the array with shapes:
		for (int i = 0; i < s.length; i++)
			s[i] = gen.next();
		// Make polymorphic method calls:
		for (Shape shp : s)
			shp.draw();
	}
}
