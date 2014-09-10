package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerOutputThread extends Thread{
	private Socket socket;
	private List<ServerOutputThread> list=new ArrayList<ServerOutputThread>();
	private OutputStream os=null;
	public ServerOutputThread(Socket socket, List<ServerOutputThread> list) throws IOException {
		this.socket = socket;
		this.list=list;
		os=socket.getOutputStream();
	}
	
	public void send(String str) throws IOException{
		os.write(str.getBytes());
	}
	
	
	@Override
	public void run() {
		try {
			
			while(true){
				BufferedReader br=new BufferedReader(
						new InputStreamReader(System.in));
				
				String str=br.readLine();
				for(ServerOutputThread t:list){
					t.send(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}



































