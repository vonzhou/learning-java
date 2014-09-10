package io;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
	public static void main(String[] args) {
		File f=new File("f:/test.txt");
		try {
			System.out.println(f.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(f.delete());
	}

}
