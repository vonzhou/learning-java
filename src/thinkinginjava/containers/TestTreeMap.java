package thinkinginjava.containers;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		String str = "wqjwioqrjworaabcdafamvlpwirujzhfp";
		SortedMap<Character, Integer> map = strToMap(str);

		System.out.println(mapToString(map));
	}

	private static SortedMap<Character, Integer> strToMap(String str) {
		if (str == null || str.length() == 0)
			return null;
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
			} else {
				count++;
				map.put(ch, count);
			}
		}
		return map;
	}

	public static String mapToString(SortedMap<Character, Integer> map) {
		if (map == null)
			return null;
		StringBuilder res = new StringBuilder();
		Iterator<Character> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Character key = iter.next();
			res.append(key).append(" : ").append(map.get(key)).append(", ");
		}

		return res.toString();
	}

}
