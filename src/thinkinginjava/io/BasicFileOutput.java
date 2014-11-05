package thinkinginjava.io;

import java.io.*;

public class BasicFileOutput {
	static String file = "C:/data/hello.txt";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("README.txt")));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		out.close();
		
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}
} 
