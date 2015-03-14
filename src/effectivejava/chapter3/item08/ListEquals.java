package effectivejava.chapter3.item08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEquals {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int[] a = {1,2,4};
		int[] b = {1,2,4};
		System.out.println(Arrays.equals(a, b));
	}

}
