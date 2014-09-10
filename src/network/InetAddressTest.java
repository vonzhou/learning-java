package network;

import java.net.InetAddress;
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress address=InetAddress.getLocalHost();
		
		System.out.println(address);
		
		//address=InetAddress.getByName("www.sohu.com");
		address=InetAddress.getByName("localhost");
		System.out.println(address);
		
		
		
		
	}

}
