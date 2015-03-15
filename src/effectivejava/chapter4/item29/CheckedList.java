package effectivejava.chapter4.item29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckedList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("af", "vonzhou", "hello", "luyna"));
		
		List<String> l2 = Collections.checkedList(list, String.class);
	}

}
