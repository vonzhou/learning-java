package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutputStreamTest {
	public static void main(String[] args) throws Exception {
		OutputStream os=new FileOutputStream("f:/hello.txt");
		BufferedOutputStream bos=new BufferedOutputStream(os);
		bos.write("vonzhou".getBytes());
		bos.close();//在释放资源前，底层会调用flush方法，将缓冲区的内容写到文件中
		os.close();
	}

}
