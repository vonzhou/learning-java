
package classloader;

class Cat2{
	public static int a=9;
	static {
		System.out.println("Cat2 static block");
	}
	public static void function(){
		System.out.println("do sth ");
	}
}

class Lion extends Cat2{
	static {
		System.out.println("lion static block");
	}
	
}

public class Test6 {
	public static void main(String[] args) {
		//System.out.println(Lion.a);
		//new Cat2().function();
		Lion.function();
	}
}
















