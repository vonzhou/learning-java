package network;

import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost",4000);
		
			new ClientInputThread(socket).start();
			new ClientOutputThread(socket).start();
		
	}

}
