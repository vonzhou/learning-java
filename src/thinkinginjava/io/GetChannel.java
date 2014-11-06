package thinkinginjava.io;

// Getting channels from streams
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		// Write a file:
		FileChannel fc = new FileOutputStream("C:/data/data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		fc.close();
		
		// Add to the end of the file:
		fc = new RandomAccessFile("C:/data/data.txt", "rw").getChannel();
		fc.position(fc.size()); // Move to the end
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		
		// Read the file:
		fc = new FileInputStream("C:/data/data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip(); // for reading
		while (buff.hasRemaining())
			System.out.print((char) buff.get());
	}
} 
