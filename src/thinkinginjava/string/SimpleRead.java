//: strings/SimpleRead.java
package thinkinginjava.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
	public static BufferedReader input = new BufferedReader(new StringReader(
			"Sir Robin of Camelot\n22 1.61803"));

	public static void main(String[] args) {
		try {
			System.out.println("What is your name?");
			String name = input.readLine(); // 注意到：遇到换行结束
			System.out.println(name);
			System.out
					.println("How old are you? What is your favorite double?");
			System.out.println("(input: <age> <double>)");
			String numbers = input.readLine();
			System.out.println(numbers);
			// 分词
			String[] numArray = numbers.split(" ");
			int age = Integer.parseInt(numArray[0]);
			double favorite = Double.parseDouble(numArray[1]);
			System.out.format("Hi %s.\n", name);
			System.out.format("In 5 years you will be %d.\n", age + 5);
			System.out.format("My favorite double is %f.", favorite / 2);
		} catch (IOException e) {
			System.err.println("I/O exception");
		}
	}
}
