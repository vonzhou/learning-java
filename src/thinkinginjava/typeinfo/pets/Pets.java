//: typeinfo/pets/Pets.java

// Facade to produce a default PetCreator.
package thinkinginjava.typeinfo.pets;

import java.util.ArrayList;

// 是 LiteralPetCreator 的外观
public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();

	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
} // /:~
