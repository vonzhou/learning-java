package thinginjava.fojob;


class Base {
	private void foo(){
		System.out.println("Base : foo()");
	}
}
/*
 * Note that if you try to apply the @Override annotation to Child.foo() you'll get a compile-time error.
 *  So long as you have your compiler/IDE set to give you warnings or errors if you're
 *  missing an @Override annotation, all should be well.
 */
class Child extends Base{
	//@Override
	private void foo(){
		System.out.println("Child : foo()");
	}
}


public class OverridePrivateMethod {
	public static void main(String[] args) {
		Base b = new Child();
		//b.foo();
	}
	
}
