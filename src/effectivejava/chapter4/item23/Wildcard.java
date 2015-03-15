package effectivejava.chapter4.item23;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {
	public static void main(String[] args) {
		List<?> list = new ArrayList<String>();
		//list.add("asfasdf");
		//The method add(capture#1-of ?) in the type List<capture#1-of ?>
		// is not applicable for the arguments (String)
		
		//ArrayList<? extends Object> list2 = new ArrayList<? extends Object>();
	}

}
