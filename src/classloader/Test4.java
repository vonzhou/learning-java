package classloader;

class Parent{
	public  static int a=5;
	static {
		System.out.println("parent static block");
	}
}
class Child extends Parent{
	public  static int b=5;
	static {
		System.out.println("child static block");
	}
}

public class Test4 {
	static {
		System.out.println("Test4 static block");
	}
	public static void main(String[] args) {
		System.out.println(Child.b);
	}

}















