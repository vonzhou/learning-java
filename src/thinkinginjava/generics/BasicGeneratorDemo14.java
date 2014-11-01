package thinkinginjava.generics;

// TIJ3 Chapter Generics, Exercise 14, page 639
/* Modify BasicGeneratorDemo.java to use the explicit form of creation for the
 * Generator (that is, use the explict constructor instead of the generic 
 * create() method). 
 */
import thinkinginjava.util.BasicGenerator;
import thinkinginjava.util.Generator;

public class BasicGeneratorDemo14 {
	public static void main(String[] args) {
		Generator<CountedObject> gen = new BasicGenerator<CountedObject>(
				CountedObject.class);
		for (int i = 0; i < 5; i++)
			System.out.println(gen.next());
	}
}