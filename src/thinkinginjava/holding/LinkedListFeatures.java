package thinkinginjava.holding;

import java.util.LinkedList;

import thinkinginjava.typeinfo.pets.Hamster;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pets;
import thinkinginjava.typeinfo.pets.Rat;

public class LinkedListFeatures {
	public static void print(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		// Identical:
		print("pets.getFirst(): " + pets.getFirst());
		print("pets.element(): " + pets.element());
		// Only differs in empty-list behavior:
		print("pets.peek(): " + pets.peek());
		// Identical; remove and return the first element:
		print("pets.remove(): " + pets.remove());
		print("pets.removeFirst(): " + pets.removeFirst());
		// Only differs in empty-list behavior:
		print("pets.poll(): " + pets.poll());
		print(pets);
		pets.addFirst(new Rat());
		print("After addFirst(): " + pets);
		pets.offer(Pets.randomPet());
		print("After offer(): " + pets);
		pets.add(Pets.randomPet());
		print("After add(): " + pets);
		pets.addLast(new Hamster());
		print("After addLast(): " + pets);
		print("pets.removeLast(): " + pets.removeLast());
	}
}
