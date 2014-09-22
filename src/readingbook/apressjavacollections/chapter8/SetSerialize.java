package readingbook.apressjavacollections.chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSerialize  {
	public static void main(String[] args) throws Exception{
		String elements[] = {"Irish Setter", "Poodle", 
			      "English Setter", "Gordon Setter", "Pug"};
		Set set = new HashSet(Arrays.asList(elements));
		
		// 序列化
		FileOutputStream fos = new FileOutputStream("C:\\data\\set.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(set);
		oos.close();
		
		// 反序列化
		FileInputStream fis = new FileInputStream("C:\\data\\set.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set set2 = (Set)ois.readObject();
		ois.close();
		
		Iterator iter = set2.iterator();
	    while (iter.hasNext()) {
	      System.out.println(iter.next());
	    }
	}

}
