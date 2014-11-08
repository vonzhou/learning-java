package thinkinginjava.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	private static String filepath = "C:/data/temp.tmp";

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			System.out.print(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration / 1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] tests = { new Tester("Stream Write") {
		public void test() throws IOException {
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File(	filepath))));
			for (int i = 0; i < numOfInts; i++)
				dos.writeInt(i);
			dos.close();
		}
	}, new Tester("Mapped Write") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile(filepath, "rw")
					.getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size())
					.asIntBuffer();
			for (int i = 0; i < numOfInts; i++)
				ib.put(i);
			fc.close();
		}
	}, new Tester("Stream Read") {
		public void test() throws IOException {
			DataInputStream dis = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filepath)));
			for (int i = 0; i < numOfInts; i++)
				dis.readInt();
			dis.close();
		}
	}, new Tester("Mapped Read") {
		public void test() throws IOException {
			FileChannel fc = new FileInputStream(new File(filepath))
					.getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size())
					.asIntBuffer();
			while (ib.hasRemaining())
				ib.get();
			fc.close();
		}
	}, new Tester("Stream Read/Write") {
		public void test() throws IOException {
			RandomAccessFile raf = new RandomAccessFile(new File(filepath),"rw");
			raf.writeInt(1);
			for (int i = 0; i < numOfUbuffInts; i++) {
				raf.seek(raf.length() - 4);
				raf.writeInt(raf.readInt());
			}
			raf.close();
		}
	}, new Tester("Mapped Read/Write") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile(new File(filepath), "rw")
					.getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size())
					.asIntBuffer();
			ib.put(0);
			for (int i = 1; i < numOfUbuffInts; i++)
				ib.put(ib.get(i - 1));
			fc.close();
		}
	} };

	public static void main(String[] args) {
		for (Tester test : tests)
			test.runTest();
	}
} 
/*
 Stream Write: 0.93
Mapped Write: 0.12
Stream Read: 0.91
Mapped Read: 0.05
Stream Read/Write: 9.75
Mapped Read/Write: 0.01
 */
