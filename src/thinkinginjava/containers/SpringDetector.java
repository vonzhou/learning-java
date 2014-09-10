package thinkinginjava.containers;

// What will the weather be?
import static thinkinginjava.util.Print.print;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
	// Uses a Groundhog or class derived from Groundhog:
	public static <T extends Groundhog> void detectSpring(Class<T> type)
			throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		for (int i = 0; i < 10; i++)
			map.put(ghog.newInstance(i), new Prediction());
		print("map = " + map);
		Groundhog gh = ghog.newInstance(3);
		print("Looking up prediction for " + gh);
		if (map.containsKey(gh))
			print(map.get(gh));
		else
			print("Key not found: " + gh);
	}

	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
	}
}
