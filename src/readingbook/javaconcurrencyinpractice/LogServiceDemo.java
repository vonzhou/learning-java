package readingbook.javaconcurrencyinpractice;

import java.io.PrintWriter;

public class LogServiceDemo {
	public static void main(String[] args) {
		
		PrintWriter writer = new PrintWriter(System.out);
		LogService ls = new LogService(writer);
		ls.start();
		try {
			ls.log("hello");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
