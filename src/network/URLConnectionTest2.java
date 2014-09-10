package network;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

public class URLConnectionTest2 {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://localhost:8080/1/output.jsp");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		String str=null;
		while(null!=(str=br.readLine())){
			System.out.println(str);
		}
		
		
		
	}

}
