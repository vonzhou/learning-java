package basic.dp.singleton;

//利用双重检查加锁，在getInstance方法中减少使用同步，用
public class Singletion4 {
	private static Singletion4 uniqueInstance;

	private Singletion4() {
	}

	// 每次都需要同步
	public static synchronized Singletion4 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singletion4();
		}
		return uniqueInstance;
	}
}
