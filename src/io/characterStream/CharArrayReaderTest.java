package io.characterStream;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderTest {
	public static void main(String[] args) throws IOException {
		
		String str="abcdefg";
		char[] c=new char[str.length()];
		//½«×Ö·û´®×Ö·ûÊý×éch
		str.getChars(0, str.length(),c,0);
		
		CharArrayReader car=new CharArrayReader(c);
		int i;
		while(-1!=(i=car.read())){
			System.out.println((char)i);
		}
		
		
		
		
	}
}
