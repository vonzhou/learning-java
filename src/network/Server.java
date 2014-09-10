package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(4000);
		List<ServerOutputThread> list=new ArrayList<ServerOutputThread>();
		
		
		while(true){
			Socket socket =serverSocket.accept();
			new ServerInputThread(socket).start();
			
			ServerOutputThread t=	new ServerOutputThread(socket,list);
			t.start();
			list.add(t);
			
			
		}
	}
}
