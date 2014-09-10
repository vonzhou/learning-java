//: typeinfo/PetCount4.java
package thinkinginjava.typeinfo;

import static thinkinginjava.util.Print.print;
import static thinkinginjava.util.Print.printnb;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pets;
import thinkinginjava.util.TypeCounter;

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
}
