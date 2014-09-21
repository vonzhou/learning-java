package readingbook.apressjavacollections.chapter4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo {
	public static void main(String[] args) throws Exception{
		Vector v = new Vector(3);
		v.add(new FileInputStream("C:\\data\\1.txt"));
		v.add(new FileInputStream("C:\\data\\2.txt"));
		v.add(new FileInputStream("C:\\data\\3.txt"));
		
		Enumeration e = v.elements();
		SequenceInputStream sis = new SequenceInputStream(e);
		InputStreamReader isr = new InputStreamReader(sis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while((line = br.readLine()) != null){
			System.out.println(line);
			// processData(line);
		}
		
		br.close();
		sis.close();
		
		
	}
}

/**
 * 注意在每个文件的每一行都要有换行符，否则输出很混乱。
 */
