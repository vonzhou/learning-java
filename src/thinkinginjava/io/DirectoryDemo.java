package thinkinginjava.io;

// Sample use of Directory utilities.
import java.io.File;

import thinkinginjava.util.Directory;
import thinkinginjava.util.PPrint;

public class DirectoryDemo {
	public static void main(String[] args) {
		// All directories:
		PPrint.pprint(Directory.walk(".").dirs);
		// All files beginning with 'T'
		for (File file : Directory.local(".", "T.*"))
			print(file);
		print("----------------------");
		// All Java files beginning with 'T':
		for (File file : Directory.walk(".", "T.*\\.java"))
			print(file);
		print("======================");
		// Class files containing "Z" or "z":
		for (File file : Directory.walk(".", ".*[Zz].*\\.class"))
			print(file);
	}

	private static void print(Object file) {
		System.out.println(file);
		
	}
} 
