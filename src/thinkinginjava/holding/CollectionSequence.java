package thinkinginjava.holding;

import java.util.AbstractCollection;
import java.util.Iterator;

import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.typeinfo.pets.Pets;

public class CollectionSequence extends AbstractCollection<Pet> {
	private Pet[] pets = Pets.createArray(8);

	// 要实现Collection中的抽象方法
	// public abstract Iterator<E> iterator();
	// public abstract int size();

	public int size() {
		return pets.length;
	}

	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}
}
