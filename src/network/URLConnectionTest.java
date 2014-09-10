package network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://localhost:8080/1/output.jsp");
		
		URLConnection con=url.openConnection();
		InputStream is=con.getInputStream();
		
		//以上两行代码等价于
		InputStream is2=url.openStream();
		
		
		OutputStream os=new FileOutputStream("f:/hello.txt");
		
		byte[] buffer=new byte[1024];
		int length=0;
		while(-1!=(length=is.read(buffer, 0,buffer.length))){
			os.write(buffer,0,length);
		}
		os.close();
		is.close();
		
		
		
	}

}
