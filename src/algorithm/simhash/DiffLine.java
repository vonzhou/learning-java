package algorithm.simhash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 利用hashset 来判断俩文件有多少行是不同的 过程写的很乱，可以优化一下，用一个循环，否则没有扩展性
 * 
 * @author vonzhou
 * 
 */
public class DiffLine {

	public static void main(String[] args) {
		String file1 = "src/file/afile.html.s";
		String file2 = "src/file/afile1.html.s";
		String file3 = "src/file/afile2.html.s";
		String file4 = "src/file/afile3.html.s";
		String file5 = "src/file/java.html.s";
		Set<String> set1 = new HashSet<String>();
		Set<String> set12 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> set13 = new HashSet<String>();
		Set<String> set3 = new HashSet<String>();
		Set<String> set14 = new HashSet<String>();
		Set<String> set4 = new HashSet<String>();
		Set<String> set15 = new HashSet<String>();
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
				set12.add(line1);
				set13.add(line1);
				set14.add(line1);
				set15.add(line1);
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
				set5.add(line5);
			}

			// set12.retainAll(set2);// 仅保留也出现在set2中的元素
			// System.out.println("set1 ^ set2(交集) 的大小= : " + set12.size());
			// set1.removeAll(set12);
			// System.out.println("set1 - (set1 ^ set2) 的大小=  " + set1.size());
			// set2.removeAll(set12);
			// System.out.println("set2- (set1 ^ set2) 的大小=  " + set2.size());

			// set13.retainAll(set3);//
			// System.out.println("set1 ^ set3(交集) 的大小= : " + set13.size());
			// set1.removeAll(set13);
			// System.out.println("set1 - (set1 ^ set3) 的大小=  " + set1.size());
			// set3.removeAll(set13);
			// System.out.println("set3- (set1 ^ set3) 的大小=  " + set3.size());

			// set14.retainAll(set4);//
			// System.out.println("set1 ^ set4(交集) 的大小= : " + set14.size());
			// set1.removeAll(set14);
			// System.out.println("set1 - (set1 ^ set4) 的大小=  " + set1.size());
			// set4.removeAll(set14);
			// System.out.println("set4- (set1 ^ set4) 的大小=  " + set4.size());

			set15.retainAll(set5);//
			System.out.println("set1 ^ set5(交集) 的大小= : " + set15.size());
			set1.removeAll(set15);
			System.out.println("set1 - (set1 ^ set5) 的大小=  " + set1.size());
			set4.removeAll(set15);
			System.out.println("set5- (set1 ^ set5) 的大小=  " + set5.size());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				br1.close();
				br2.close();
			} catch (Exception ce) {
			}
		}

	}

}
