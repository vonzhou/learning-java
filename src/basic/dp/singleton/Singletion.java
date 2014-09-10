package basic.dp.singleton;

//经典实现方式，但是在多线程环境下就会出问题，
//可能连个线程同时进入了uniqueInstance==null那条控制路径
public class Singletion {
	private static Singletion uniqueInstance;

	private Singletion() {
	} //

	public static Singletion getInstance() {
		if (uniqueInstance == null) { // 延迟实例化，懒汉式
			uniqueInstance = new Singletion();
		}
		return uniqueInstance;
	}
}
