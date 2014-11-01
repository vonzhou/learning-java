package thinkinginjava.generics;

import java.util.List;
import java.util.Map;

import thinkinginjava.typeinfo.pets.Person;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.util.New;

public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPeople) {
	}

	public static void main(String[] args) {
		// f(New.map()); // Does not compile
	}
} // /:~
