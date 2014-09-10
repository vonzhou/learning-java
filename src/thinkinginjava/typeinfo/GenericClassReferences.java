//: typeinfo/GenericClassReferences.java
package thinkinginjava.typeinfo;

public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		Class genericIntClass2 = Integer.class; // Same thing
		Class<Integer> genericIntClass3 = Integer.class; // Same thing
		System.out.println(genericIntClass == genericIntClass2);// false
		System.out.println(genericIntClass == genericIntClass3); // false
		Class<Integer> genericIntClass4 = int.class; // Same thing
		System.out.println(genericIntClass == genericIntClass4); // true
		intClass = double.class;
		// genericIntClass = Double.class; // Illegal
	}
} // /:~
