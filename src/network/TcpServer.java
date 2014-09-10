package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket =new ServerSocket(5000);
			Socket socket=serverSocket.accept();
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
			os.write("hello vonzhou".getBytes());
			byte[] buffer =new byte[200];
			int length=0;
			while(-1!=(length=is.read(buffer,0,buffer.length))){
				String str=new String(buffer,0,length);
				System.out.println(str);
			}
			
			
			
			is.close();
			os.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
