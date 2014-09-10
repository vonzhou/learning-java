package thinkinginjava.polymorphism;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

class RandomWords implements Readable {

	@Override
	public int read(CharBuffer arg0) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class TestScanner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			String str = s.nextLine();
			System.out.println(str);
			if (str.equals("exit"))
				break;
		}
	}

}
