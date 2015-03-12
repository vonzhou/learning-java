package thinginjava.fojob;





public class OverridePrivateMethod2 {
	public static class Base {
		private void foo(){
			System.out.println("Base : foo()");
		}
	}

	public static class Child extends Base{
		//@Override
		private void foo(){
			System.out.println("Child : foo()");
		}
	}
	
	public static void main(String[] args) {
		Base b = new Child();
		b.foo();   // Base : foo()
	}
	
}
