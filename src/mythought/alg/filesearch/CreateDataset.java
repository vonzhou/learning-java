package mythought.alg.filesearch;

import java.io.RandomAccessFile;
import java.util.Arrays;

public class CreateDataset {
	
	public static void create(String path, String opath) throws Exception {
		// Scan the file to construct the data structure for use
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		RandomAccessFile out = new RandomAccessFile(opath, "rw");
		byte buffer[] = new byte[1024]; //buf this current line
		int b;
		// raf.length();
		int offset = 0;
		int bytesRead = 0;
		int bufferIndex = 0;
		System.out.println("Total Length: " + raf.length());
		while((b = raf.read()) != -1){
			// buffer it first
			buffer[bufferIndex++] = (byte)b; // int to byte
			bytesRead ++ ;
			
			if(b == '\n'){
				String line = new String(buffer);
				line = line.replace("\"", "");
				//System.out.println(line);
				String cells[] = line.split(",");
				int startIP = IPv4Util.ip2int(cells[0]);
				int endIP = IPv4Util.ip2int(cells[1]);
				String res = startIP + ","+ endIP + "," + cells[2] + "," + cells[3] + "," + cells[4];
				// write it
				//out.writeBytes(res);
				System.out.println(res);
				
				// reset
				bufferIndex = 0;
				Arrays.fill(buffer, (byte)0);
				
				offset += bytesRead;// prepare offset for next entry
				bytesRead = 0;
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		long start = System.currentTimeMillis();
		String filePath = "resource/alg-dataset/dbip-city.csv";
		String outPath = "resource/alg-dataset/dbip-city2.csv";
		create(filePath, outPath);
		long end = System.currentTimeMillis();
		System.out.println("Time Init Cost: " + (end - start)/1000 + "s");
	}

}
