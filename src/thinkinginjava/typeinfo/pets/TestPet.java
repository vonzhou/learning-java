package thinkinginjava.typeinfo.pets;

public class TestPet {
	public static void main(String[] args) {
		Individual p = new Person("vonzhou");
		Individual pet = new Pet("abc");

		System.out.println(p.compareTo(pet));
		System.out.println("Person".compareTo("Pet"));// same as above
	}

}
