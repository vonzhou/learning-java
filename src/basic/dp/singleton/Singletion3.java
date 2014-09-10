package basic.dp.singleton;

//使用“急切”创建实例（饿汉式），JVM会在线程方位这个静态变量之前，一定先创建这个实例，所以线程安全。
//缺点是不是在需要的时候才创建实例
public class Singletion3 {
	private static Singletion3 uniqueInstance = new Singletion3();

	private Singletion3() {
	}

	// 每次都需要同步
	public static synchronized Singletion3 getInstance() {
		return uniqueInstance;
	}
}
