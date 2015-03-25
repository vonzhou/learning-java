package readingbook.zengxianjie.chapter03;

import java.lang.reflect.Proxy;

public class TestDynamicProxy {
	
	public static void main(String[] args) {
		Calculator cal = new CalculatorImpl();
		LogHandler handler = new LogHandler(cal);
		Calculator proxy = (Calculator) Proxy.newProxyInstance(cal.getClass().getClassLoader()
				, cal.getClass().getInterfaces(), handler);
		System.out.println(proxy.add(78, 234));
	}

}
