package hello;

import java.util.Random;

class Value {
	int i; // package access

	public Value(int i) {
		this.i = i;
	}
}

public class FinalData {
	private static Random rand = new Random(47);
	private String id;

	public FinalData(String id) {
		this.id = id;
	}

	// can be compile-time constants
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	// typical public constant
	public static final int VALUE_THREE = 100;

	// cannot be compile-time constants
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);

	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);

	// array
	private final int[] a = { 23, 435, 4, 65, 34, 23 };

	public String toString() {
		return id + ":" + "i4 = " + i4 + ",INT_5 = " + INT_5;
	}

	public static void main(String[] args) {
		FinalData fd1 = new FinalData("fd1");
		// fd1.valueOne ++; //ERROR: cannot final data
		fd1.v2.i++; // the reference is constant ,but Object is not
		fd1.v1 = new Value(100);
		// fd1.v2 = new Value(100); //Error
		for (int i = 0; i < fd1.a.length; i++)
			fd1.a[i]++;
		// Object isnot constant
		System.out.println(fd1);
		System.out.println("=======");
		FinalData fd2 = new FinalData("fd2");
		System.out.println(fd1);
		System.out.println(fd2);

	}

}
