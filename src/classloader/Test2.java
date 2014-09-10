package classloader;

class FinalTest{
	public static final int x=6/2;//编译时常量，不会导致类的初始化
	static {
		System.out.println("FinalTest static block!");
	}
}

public class Test2 {
	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}

}
