package mythought.alg.filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * For every record in file, use a entry to abstract it in memory to construct index
 * When need a line we read it by the offset.
 */
class Entry {
	private int beginIP;
	private int endIP;
	private int offset;

	public Entry(int beginIP, int endIP, int offset) {
		this.beginIP = beginIP;
		this.endIP = endIP;
		this.offset = offset;
	}

	public int getBeginIP() {
		return beginIP;
	}

	public int getEndIP() {
		return endIP;
	}

	public int getOffset() {
		return offset;
	}

}

public class BinarySearchFile {
	private File file;
	private String path;
	private ArrayList<Entry> entries;// TODO  自己用数组实现

	public BinarySearchFile(String path) {
		this.path = path;
	}

	public int lines() throws Exception {
		LineNumberReader lnr = new LineNumberReader(new FileReader(file));
		lnr.skip(Long.MAX_VALUE);
		//System.out.println(lnr.getLineNumber() + 1); //Add 1 because line
		// index starts at 0
		// Finally, the LineNumberReader object should be closed to prevent
		// resource leak
		lnr.close();
		return lnr.getLineNumber() + 1;
	}
/*
	public void init() throws Exception {
		// Scan the file to construct the data structure for use
		file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		entries = new Entry[this.lines()];
		int k = 0;

		int offset = 0;
		while ((line = reader.readLine()) != null) {
			line = line.replace("\"", "");
			int len = line.length();
			String cells[] = line.split(",");
			int startIP = IPv4Util.ip2int(cells[0]);
			int endIP = IPv4Util.ip2int(cells[1]);
			//System.out.println("==" + startIP + "-" + endIP);
			Entry entry = new Entry(startIP, endIP,  offset);
			entries[k++] = entry;
			
			// NB.这里存在问题，因为offset是字节级别的，而字符串和特定编码有关
			offset += len;
		}
	}
*/
	public void init2() throws Exception {
		entries = new ArrayList<Entry>();
		// Scan the file to construct the data structure for use
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		byte buffer[] = new byte[1024]; //buf this current line
		int b;
		// raf.length();
		int offset = 0;
		int bytesRead = 0;
		int bufferIndex = 0;
		while((b = raf.read()) != -1){
			// buffer it first
			buffer[bufferIndex++] = (byte)b; // int to byte
			bytesRead ++ ;
			
			if(b == '\n'){
				String line = new String(buffer);
				line = line.replace("\"", "");
				//System.out.println(line);
				int len = line.length();
				String cells[] = line.split(",");
				int startIP = IPv4Util.ip2int(cells[0]);
				int endIP = IPv4Util.ip2int(cells[1]);
				//System.out.println("==" + startIP + "-" + endIP + ", " + offset);
				Entry entry = new Entry(startIP, endIP,  offset);
				entries.add(entry);
				
				// reset
				bufferIndex = 0;
				Arrays.fill(buffer, (byte)0);
				
				offset += bytesRead;// prepare offset for next entry
				bytesRead = 0;
			}
		}
	}

	/*
	 * Given a IP string and I will return you a **IP Location Entry**
	 * Binary Search in entries[] ...
	 */
	public IPLocationEntry search(String ip) throws Exception{
		int index = this.searchIndex(ip);
		//validate the index
		Entry en = entries.get(index);
		//System.out.println(index + ":" + en.getBeginIP() + "-" + en.getEndIP() + ", " + ip);
		// locate by offset
		int offset = en.getOffset();
		
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		//System.out.println("Offset: " + offset + ", File Size: " + raf.length());
		raf.seek(offset);
		String res = raf.readLine();
		//System.out.println(res);
		return constructIPLocationEntry(res);
	}
	
	private IPLocationEntry constructIPLocationEntry(String res) {
		res = res.replace("\"", "");
		String cells[] = res.split(",");
		IPLocationEntry en = new IPLocationEntry(cells[0],cells[1],cells[2], cells[3],cells[4]);
		return en;
	}

	public int searchIndex(String ip) {
		//validate it
		int target = IPv4Util.ip2int(ip);
		int low = 0, high = entries.size();
		int mid = 0;
		while(low <= high){
			mid = (low + high)/2;
			if(ipInRegion(target, mid))
				return mid;
			else if(ipLt(target, mid))
				high = mid - 1;
			else 
				low = mid + 1;
		}
		
		return -1; // no exist!
	}

	//IP less than this range
	private boolean ipLt(int target, int mid) {
		Entry en = entries.get(mid);
		if(target < en.getBeginIP())
			return true;
		return false;
	}

	private boolean ipInRegion(int target, int mid) {
		Entry en = entries.get(mid);
		if(target >= en.getBeginIP() && target <= en.getEndIP())
			return true;
		return false;
	}

	public static void main(String args[]) throws Exception {
		// -----------------Test Init-------------------
		long start = System.currentTimeMillis();
		String filePath = "resource/alg-dataset/dbip-city.csv";
		BinarySearchFile bsf = new BinarySearchFile(filePath);
		bsf.init2();
		long end = System.currentTimeMillis();
		System.out.println("Time Init Cost: " + (end - start) + "ms");
		
		// ------------------Test Search -------------------
		long start2 = System.currentTimeMillis();
		IPLocationEntry en = bsf.search("1.1.74.1");
		System.out.println(en);
		long end2 = System.currentTimeMillis();
		System.out.println("Time Init Cost: " + (end2 - start2) + "ms");
		
		// Then We Can Operate With this IPLocationEntry
	}

}
