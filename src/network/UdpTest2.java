package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTest2 {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket=new DatagramSocket(7000);
		
		byte[] buf=new byte[1024];
		DatagramPacket packet=new DatagramPacket(buf,buf.length);
		socket.receive(packet);
		System.out.println(new String(buf,0,packet.getLength()));
		socket.close();
		
		
		
		
		
		
	}

}
