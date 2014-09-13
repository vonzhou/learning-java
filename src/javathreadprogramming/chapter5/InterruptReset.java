package javathreadprogramming.chapter5;
public class InterruptReset extends Object {
	public static void main(String[] args) {
		System.out.println(
			"Point X: Thread.interrupted()=" + Thread.interrupted());
		Thread.currentThread().interrupt();
		//Thread.currentThread().interrupt();
		// 如果interrupt被置，并且返回之前的标示
		System.out.println(
			"Point Y: Thread.interrupted()=" + Thread.interrupted());
		System.out.println(
			"Point Z: Thread.interrupted()=" + Thread.interrupted());
	}
}
