package effectivejava.chapter2;

import java.math.BigInteger;
import java.util.Random;

public class TestBigInteger {
	public static void main(String[] args) {
		Boolean b = Boolean.valueOf(true);

		BigInteger bi = BigInteger.probablePrime(32, new Random(47));
		System.out.println(bi);
	}
}
