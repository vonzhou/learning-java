package thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			c.add(i); // Autoboxing
		for (Integer i : c)
			System.out.print(i + ", ");
	}
}
