package classloader;

class Ant{
	static {
		System.out.println("another neat tool .");
	}
}

public class Test7 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader c=ClassLoader.getSystemClassLoader();
		c.loadClass("classloader.Ant");
		System.out.println("===================");
		Class<?> clazz=Class.forName("classloader.Ant");
	}

}
