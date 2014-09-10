package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamTest {
	public static void main(String[] args) throws Exception {
		
		InputStream is=new FileInputStream("f:/hello.txt");
		//等价于以下两行
		File file=new File("f:/hello.txt");
		InputStream is2=new FileInputStream(file);
		
		byte[] buffer=new byte[200];
		int length=0;
		
		while((length=is.read(buffer, 0, 200))!=-1){
			//System.out.println(length);
			String str=new String (buffer,0,length);
			System.out.println(str);
		}
		is.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
