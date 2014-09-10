package io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
		String str="abc";
		byte[] temp=str.getBytes();
		
		ByteArrayInputStream bais=new ByteArrayInputStream(temp);
		
		for(int i=0;i<2;i++){
			int c=0;
			while(-1!=(c=bais.read())){
				if(i==0)
				System.out.println((char)c);
				else System.out.println(Character.toUpperCase((char)c));
			}
			bais.reset();///////////////////////
		}
	}

}
