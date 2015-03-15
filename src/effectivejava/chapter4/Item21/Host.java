package effectivejava.chapter4.Item21;

import java.util.Comparator;

public class Host {
	private static class StrLenCmp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.length()-o2.length();
		}
	}
	
	public static final Comparator<String> STRING_LEN_COMPARATOR=
			new StrLenCmp();

}
