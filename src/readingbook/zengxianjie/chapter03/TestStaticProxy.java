package readingbook.zengxianjie.chapter03;

public class TestStaticProxy {
	public static void main(String[] args) {
		CalculatorProxy p = new CalculatorProxy(new CalculatorImpl());
		System.out.println(p.add(10, 99));
	}

}
