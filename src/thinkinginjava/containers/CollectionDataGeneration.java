package thinkinginjava.containers;

// Using the Generators defined in the Arrays chapter.
import java.util.*;

import thinkinginjava.util.CollectionData;
import thinkinginjava.util.RandomGenerator;

public class CollectionDataGeneration {
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(CollectionData.list( // Convenience method
				new RandomGenerator.String(9), 10)));
		System.out.println(new HashSet<Integer>(new CollectionData<Integer>(
				new RandomGenerator.Integer(), 10)));
	}
} 
