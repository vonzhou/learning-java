package effectivejava.chapter2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHashMap {

	// ·ºÐÍ·½·¨
	public static <K, V> Map<K, V> newInstance() {
		return new HashMap<K, V>();
	}

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		Map<String, List<String>> map2 = TestHashMap.newInstance();

	}

}
