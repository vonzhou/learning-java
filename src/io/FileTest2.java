package io;

import java.io.File;

public class FileTest2 {
	public static void main(String[] args) {
		File file=new File("f:/abc/xyz/hello");
		System.out.println(file.mkdir());//只能创建一层目录
		
		System.out.println(file.mkdirs());
		System.out.println(file.isDirectory());
	}

}
