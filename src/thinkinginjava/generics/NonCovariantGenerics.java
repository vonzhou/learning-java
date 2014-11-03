package thinkinginjava.generics;

// {CompileTimeError} (Won't compile)
import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
	// Compile Error: incompatible types:
	//»á³ö´í
	//List<Fruit> flist = new ArrayList<Apple>();
} 
