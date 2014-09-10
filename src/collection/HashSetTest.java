package collection;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet set=new HashSet();
		System.out.println(set.add("a"));
		System.out.println(set.add("a"));
		set.add("b");
		System.out.println(set);
	}

}
