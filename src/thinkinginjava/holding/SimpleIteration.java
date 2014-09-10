package thinkinginjava.holding;

import java.util.Iterator;
import java.util.List;

import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pets;

public class SimpleIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
		// A simpler approach, when possible:
		for (Pet p : pets)
			System.out.print(p.id() + ":" + p + " ");
		System.out.println();
		// An Iterator can also remove elements:
		it = pets.iterator();
		for (int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(pets);
	}
}
