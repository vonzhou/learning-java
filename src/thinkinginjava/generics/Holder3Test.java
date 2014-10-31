package thinkinginjava.generics;

import thinkinginjava.typeinfo.pets.Cat;
import thinkinginjava.typeinfo.pets.Dog;
import thinkinginjava.typeinfo.pets.Pet;

public class Holder3Test {
	public static void main(String[] args) {
		Holder3<Pet> hh = new Holder3<Pet>(new Dog());
		hh.set(new Cat());
	}

}
