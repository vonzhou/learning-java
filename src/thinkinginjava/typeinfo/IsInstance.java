package thinkinginjava.typeinfo;

import thinkinginjava.typeinfo.pets.*;

public class IsInstance {
	public static void main(String[] args) {
		Pet p = new Pet();
		Pet d = new Dog();
		System.out.println(Pet.class.isInstance(p));
		System.out.println(Pet.class.isInstance(d));
		System.out.println(Dog.class.isInstance(p));
		System.out.println(Dog.class.isInstance(d));
	}

}
