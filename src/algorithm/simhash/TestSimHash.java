package algorithm.simhash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 通过从文件中读取digest来计算每个文件的simhash 判断相似
 * 
 * @author vonzhou
 * 
 */
public class TestSimHash {

	public static void main(String[] args) {
		String file1 = "src/file/afile.html.s";
		String file2 = "src/file/afile1.html.s";
		String file3 = "src/file/afile2.html.s";
		String file4 = "src/file/afile3.html.s";
		String file5 = "src/file/java.html.s";
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> set3 = new HashSet<String>();
		Set<String> set4 = new HashSet<String>();
		Set<String> set5 = new HashSet<String>();
		// String s = System.getProperty("user.dir");
		// System.out.println(s);

		BufferedReader br1 = null;
		BufferedReader br2 = null;
		BufferedReader br3 = null;
		BufferedReader br4 = null;
		BufferedReader br5 = null;

		try {
			br1 = new BufferedReader(new InputStreamReader(new FileInputStream(
					file1)));
			br2 = new BufferedReader(new InputStreamReader(new FileInputStream(
					file2)));
			br3 = new BufferedReader(new InputStreamReader(new FileInputStream(
					file3)));
			br4 = new BufferedReader(new InputStreamReader(new FileInputStream(
					file4)));
			br5 = new BufferedReader(new InputStreamReader(new FileInputStream(
					file5)));
			String line1 = null;
			String line2 = null;
			String line3 = null;
			String line4 = null;
			String line5 = null;
			while ((line1 = br1.readLine()) != null) {
				set1.add(line1);
			}
			while ((line2 = br2.readLine()) != null) {
				set2.add(line2);
			}
			while ((line3 = br3.readLine()) != null) {
				set3.add(line3);
			}
			while ((line4 = br4.readLine()) != null) {
				set4.add(line4);
			}
			while ((line5 = br5.readLine()) != null) {
				set4.add(line5);
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				br1.close();
				br2.close();
				br3.close();
				br4.close();
				br5.close();
			} catch (Exception ce) {
			}
		}

		// 上面是读取每个文件，把里面的String存储到hashset中，
		// 接下来构造SimHash，进行对比测试
		System.out.println(set1.size());

		SimHash2 sm1 = new SimHash2(set1, 512);
		SimHash2 sm2 = new SimHash2(set2, 512);
		SimHash2 sm3 = new SimHash2(set3, 512);
		SimHash2 sm4 = new SimHash2(set4, 512);
		SimHash2 sm5 = new SimHash2(set5, 512);
		System.out.println("simhash1 : " + sm1.getIntSimHash());
		System.out.println("simhash2 : " + sm2.getIntSimHash());
		System.out.println("simhash3 : " + sm3.getIntSimHash());
		System.out.println("simhash4 : " + sm4.getIntSimHash());
		System.out.println("simhash5 : " + sm5.getIntSimHash());
		System.out
				.println("Hamming distance 1-2 : " + sm1.hammingDistance(sm2));
		System.out
				.println("Hamming distance 1-3 : " + sm1.hammingDistance(sm3));
		System.out
				.println("Hamming distance 1-4 : " + sm1.hammingDistance(sm4));
		System.out
				.println("Hamming distance 1-5 : " + sm1.hammingDistance(sm5));

	}

}
