package effectivejava.chapter3.item11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionCopyConstructor {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		List<String> l2 = new LinkedList<String>();
		l.add("abc");
		l2.add("vonzhou");
		l2 = new ArrayList<String>(l2);
	}

}
