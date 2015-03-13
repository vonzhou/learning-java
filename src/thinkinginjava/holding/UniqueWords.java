package thinkinginjava.holding;

import java.util.*;

import thinkinginjava.util.TextFile;

public class UniqueWords {
	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(new TextFile(
				"SetOperations.java", "\\W+"));
		System.out.println(words);
	}
}
