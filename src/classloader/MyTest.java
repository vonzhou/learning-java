package classloader;

class Cat{
	public static final Cat c=null;
	static {
		System.out.println("hello java");
	};
}

public class MyTest {
	public static void main(String[] args) {
		System.out.println(Cat.c);
	}

}
