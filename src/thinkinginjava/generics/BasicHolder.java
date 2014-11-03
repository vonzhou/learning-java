package thinkinginjava.generics;

public class BasicHolder<T> {
	private static  int cnt = 0;
	private  final int id = cnt++;
	
	T element;

	void set(T arg) {
		element = arg;
	}

	T get() {
		return element;
	}

	void f() {
		System.out.println(element.getClass().getSimpleName() + " : " + id);
	}
} 
