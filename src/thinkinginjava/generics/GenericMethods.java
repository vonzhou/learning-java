package thinkinginjava.generics;

public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
		System.out.println(x.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
} 
