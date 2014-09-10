package thinkinginjava.arrays;

public class TestArray {
	public static int[] func(int n) {
		int[] arr = { 1, 3, 5, 6 };
		return arr;
	}

	public static void func2(int n) {
		int a = 9;
		int b = 10;
		System.out.println("in func2....");
	}

	public static void main(String[] args) {
		int[] b = func(4);
		func2(8);
		System.out.println(b[0]);
	}
}
