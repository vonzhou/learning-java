package io.characterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw=new BufferedWriter(new FileWriter("file2.txt",true));
		bw.write("hheoosjdfsdf");
		bw.close();
		
		
		
		
		
	}

}
