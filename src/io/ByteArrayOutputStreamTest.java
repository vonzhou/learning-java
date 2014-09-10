package io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteArrayOutputStreamTest {
	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		//String str="决战琼华之巅";//一汉字占两个字节
		String str="vonzhou";
		byte[] buffer=str.getBytes();
		baos.write(buffer);//将字符串对应的字节流写到 字节输出流中
		
		byte[] result=baos.toByteArray();//将字节从流中拿出来
		
		System.out.println(result.length);
		for(int i=0;i<result.length;i++){
			System.out.println((char)result[i]);
		}
		
		//将字节流中的内容写入到文件输出流中
		OutputStream os=new FileOutputStream("hello.txt");
		baos.writeTo(os);
		baos.close();
		os.close();
		
		
		
	}

}
