package mythought.invertedindex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
	// key word <----> doc file
	private Map<String, Set<String>> indexs = new HashMap<String, Set<String>>();

	// 这里假设都是小文件
	public void addFile(String fileName, String content) {
		String[] words = content.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			// only record first appeared position
			Set<String> wordIndex = indexs.get(word);
			if (wordIndex == null) {
				wordIndex = new HashSet<String>();
				indexs.put(word, wordIndex);
			}

			wordIndex.add("("+fileName + "," + i+")");
		}
	}
	
	public void addFile(String fileName) throws Exception{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(" ");// 每行直接串接
	            line = br.readLine();
	        }
	        this.addFile(fileName, sb.toString());
	    } catch(Exception e){
	    	e.printStackTrace();
	    }finally {
	        br.close();
	    }
	}

	public Set<String> search(String keyword) {
		Set<String> results = indexs.get(keyword);
		return new HashSet<String>(results);
	}

	public static void main(String[] args) throws Exception{
		InvertedIndex test = new InvertedIndex();
		test.addFile("file1", "hello fuck world todotodo");
		test.addFile("file2", "go to get it if you want it");
		test.addFile("C:/data/hello.txt");

		System.out.println(test.search("it"));
		System.out.println(test.search("you"));
		System.out.println(test.search("vonzhou"));
	}
}
