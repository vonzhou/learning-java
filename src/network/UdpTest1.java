package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTest1 {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket=new DatagramSocket();
		String str="hello java";
		DatagramPacket packet=new DatagramPacket(
				str.getBytes(),str.length(),InetAddress.getByName("localhost"),7000);
		socket.send(packet);
		socket.close();
		
		
		
		
		
		
		
	}

}
