package classloader;

class Singleton{
	
	//从上到下进行初始化
	
	
	public static int n1;
	public static int n2=0;
	private static Singleton singleton=new Singleton();
	
	private Singleton(){
		n1++;
		n2++;
	}
	public static Singleton getInstance(){
		
		return singleton;
	}
}

public class Test1 {
	public static void main(String[] args) {
		Singleton s=Singleton.getInstance();
		System.out.println(Singleton.n1);
		System.out.println(Singleton.n2);
	}

}
