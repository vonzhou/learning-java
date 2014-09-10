package network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost",5000);
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		os.write("hello server".getBytes());
		
		byte[] buffer =new byte[200];
		int length=0;
		while(-1!=(length=is.read(buffer,0,buffer.length))){
			String str=new String(buffer,0,length);
			System.out.println(str);
		}
		
	}

}
