package classloader;

class Fruit{
	public  static int a=5;
	static {
		System.out.println("fruit static block");
	}
}
class Orange extends Fruit{
	public  static int b=5;
	static {
		System.out.println("orange static block");
	}
}

public class Test5 {
	static {
		System.out.println("Test5 static block");
	}
	public static void main(String[] args) {
		
		Fruit f;
		System.out.println("---------");
		f=new Fruit();
		System.out.println("---------");
		System.out.println(f.a);
		System.out.println(Orange.b);
	}

}















