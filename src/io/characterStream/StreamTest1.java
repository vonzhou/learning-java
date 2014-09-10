package io.characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//同样有装饰模式
public class StreamTest1 {
	public static void main(String[] args) throws Exception {
		OutputStreamWriter osr=new OutputStreamWriter(
				new FileOutputStream("file.txt"));
		BufferedWriter bw=new BufferedWriter(osr);
		bw.write("hello vonzhou\n");
		bw.write("决战琼华之巅");
		bw.close();
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(new FileInputStream("file.txt")));
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
		
		String str=null;
		while(null!=(str=br.readLine())){
			System.out.println(str);
		}
		br.close();
		
		
		
		
		
		
		
	}

}
