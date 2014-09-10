package thinkinginjava.holding;

import static thinkinginjava.util.Print.print;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import thinkinginjava.typeinfo.pets.Cat;
import thinkinginjava.typeinfo.pets.Cymric;
import thinkinginjava.typeinfo.pets.Dog;
import thinkinginjava.typeinfo.pets.Mutt;
import thinkinginjava.typeinfo.pets.Person;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pug;
import thinkinginjava.typeinfo.pets.Rat;

public class MapOfList {
	public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
	// static chunk
	static {
		petPeople.put(new Person("Dawn"),
				Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
		petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"),
				new Cat("Elsie May"), new Dog("Margrett")));
		petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug(
				"Louie aka Louis Snorkelstein Dupree"), new Cat(
				"Stanford aka Stinky el Negro"), new Cat("Pinkola")));
		petPeople.put(new Person("Luke"),
				Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
	}

	public static void main(String[] args) {
		print("People: " + petPeople.keySet());
		print("Pets: " + petPeople.values());
		for (Person person : petPeople.keySet()) {
			print(person + " has:");
			for (Pet pet : petPeople.get(person))
				print("    " + pet);
		}
	}
}
