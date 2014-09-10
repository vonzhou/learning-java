package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
	public static void main(String[] args) throws Exception {
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("data.txt")));
		
		int a=9;
		byte b=9;
		float c=3.14f;
		
		dos.writeByte(a);
		dos.writeInt(b);
		dos.writeFloat(c);
		dos.close();
		//向文件中写入的数据包含着数据类型的信息，不是重文本的，所以打开的二进制数据
		//
		
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
		System.out.println(dis.readByte());
		
		
		
		
		
		
	}

}
