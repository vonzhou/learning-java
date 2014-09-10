package basic.dp.singleton;

//对方法加锁，同步线程对其的调用
//但是只有第一次执行getInstance时，才真正需要同步，其他时候都是对性能的损耗
public class Singletion2 {
	private static Singletion2 uniqueInstance;

	private Singletion2() {
	}

	// 每次都需要同步
	public static synchronized Singletion2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singletion2();
		}
		return uniqueInstance;
	}
}
