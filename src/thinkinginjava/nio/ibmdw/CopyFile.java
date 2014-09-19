package thinkinginjava.nio.ibmdw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	static public void main(String args[]) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java CopyFile infile outfile");
			System.exit(1);
		}

		String infile = args[0];
		String outfile = args[1];

		// 从流中获取通道
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);

		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();

		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (true) {
			// 读入之前要清空
			buffer.clear();

			// position自动前进
			int r = fcin.read(buffer);

			if (r == -1) {
				break;
			}

			// position = 0; limit=读到的字节数
			buffer.flip();

			// 从 buffer 中读
			fcout.write(buffer);
		}
	}
}
