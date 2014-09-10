package classloader;

public class TestClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		//根类加载器加载
		Class clazz=Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());
		//系统加载器（应用加载器）加载
		Class clazz2=Class.forName("classloader.Apple");
		System.out.println(clazz2.getClassLoader());
	}

}
class Apple{
	
}
