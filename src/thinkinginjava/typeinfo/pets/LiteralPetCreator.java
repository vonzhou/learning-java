// Using class literals.
package thinkinginjava.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
	// No try block needed.
	// @SuppressWarnings("unchecked"),Ã»ÓÐ±àÒë¾¯¸æ
	public static final List<Class<? extends Pet>> allTypes = Collections
			.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class,
					Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
					Manx.class, Cymric.class, Rat.class, Mouse.class,
					Hamster.class));
	// Types for random creation:
	private static final List<Class<? extends Pet>> types = allTypes.subList(
			allTypes.indexOf(Mutt.class), allTypes.size());

	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args) {
		System.out.println(types);
	}
}
