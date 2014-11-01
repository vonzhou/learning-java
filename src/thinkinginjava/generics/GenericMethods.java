package thinkinginjava.generics;

public class GenericMethods {
	
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
		System.out.println(x.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");  // 可以传入不同的类型，好像多次重载过 ? 
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
} 
