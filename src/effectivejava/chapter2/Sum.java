package effectivejava.chapter2;

public class Sum {
	// Hideously slow program! Can you spot the object creation?
	public static void main(String[] args) {
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
