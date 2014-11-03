package thinkinginjava.generics;

// {CompileTimeError} (Won't compile)
/*
class Cat extends ComparablePet implements Comparable<Cat> {
	// Error: The interface Comparable cannot be implemented more 
	// than once with different arguments: Comparable<ComparablePet> and Comparable<Cat>
	public int compareTo(Cat arg) {
		return 0;
	}
} 

*/
