package thinkinginjava.generics;

// {CompileTimeError} (Won't compile)
import java.util.*;

public class UseList<W, T> {
	void f(List<T> v) {
	}

	// cannot
	//void f(List<W> v) {	}
} // /:~
