package thinkinginjava.generics;

// Using Collection.checkedList().
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import thinkinginjava.typeinfo.pets.Dog;

import thinkinginjava.typeinfo.pets.Cat;
import thinkinginjava.typeinfo.pets.Pet;

public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1); // Quietly accepts a Cat
		
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),
				Dog.class);
		try {
			oldStyleMethod(dogs2); // Throws an exception
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Derived types work fine:
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(),
				Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
} 
