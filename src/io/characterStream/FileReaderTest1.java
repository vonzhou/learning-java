package io.characterStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("src/io/characterStream/FileReaderTest1.java");
		
		BufferedReader br=new BufferedReader(fr);
		
		String str;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		
		br.close();
		
		
		
		
		
		
		
		
		
	}
}
