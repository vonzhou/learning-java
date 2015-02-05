package thinkinginjava.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream("C:/data/floodlightdefault.properties"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// iterate
		for(String key:prop.stringPropertyNames()){
			String value = prop.getProperty(key);
			System.out.println(key + "=>" + value);
		}
	}
}
