package mythought.alg.filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * For every record in file, use a entry to abstract it in memory
 */
class Entry{
	private int beginIP;
	private int endIP;
	private int offset;
}

public class BinarySearchFile {
	private File file;
	/*
	 * 
	 */
	public void binarySearchFile() throws IOException{
		// Scan the file to construct the data structure for use
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = reader.readLine()) != null){
			String cells[] = line.split(",");
		}
		
	}
	
	public static void main(String args[]){
		System.out.println(Integer.MAX_VALUE);
	}

}
