package io;

import java.io.IOException;
import java.io.InputStream;

public class MyStream1 {
	public static void main(String[] args) throws IOException {
		byte[] b=new byte[10];
		for(int i=0;i<10;i++){
			b[i]=(byte) i;
		}
		MyByteArrayInputStream m=new MyByteArrayInputStream(b);
		while(true){
			int c=m.read();
			if(c<0){break;}
			else{
				System.out.print(c+" ");
			}
		}
		
	}

}

class MyByteArrayInputStream extends InputStream{
	private byte[] data;
	private int pos;
	
	public MyByteArrayInputStream(byte[] b){
		this.data=b;
	}
	@Override
	public int read() throws IOException {
		return (pos<data.length)?(data[pos++]):-1;
	}}
