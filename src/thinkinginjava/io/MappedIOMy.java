package thinkinginjava.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class MappedIOMy {
	public static void test() throws IOException {
		FileChannel fc = new RandomAccessFile("C:\\data\\temp.txt","r")
				.getChannel();
		
		IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size())
				.asIntBuffer();
		for (int i = 0; i < 100; i++)
			ib.put(i);
		fc.close();
	}
	
	public static void test2() throws IOException {
		FileChannel fc = new RandomAccessFile(new File("C:\\data\\temp.txt"),"r")
				.getChannel();
		IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size())
				.asIntBuffer();
		while (ib.hasRemaining())
			System.out.println(ib.get());
		fc.close();
	}
	public static void main(String[] args) throws IOException {
		test();
	}
} 