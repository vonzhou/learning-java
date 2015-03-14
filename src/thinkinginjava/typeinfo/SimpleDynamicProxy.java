package thinkinginjava.typeinfo;

import java.lang.reflect.*;

/*
 * InvocationHandler is the interface implemented by the invocation handler of a proxy instance. 
 * Each proxy instance has an associated invocation handler. When a method is invoked on a proxy instance, 
 * the method invocation is encoded and dispatched to the invoke method of its invocation handler.
 */
class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**** proxy: " + proxy.getClass() + ", method: "
				+ method + ", args: " + args);
		if (args != null)
			for (Object arg : args)
				System.out.println("  " + arg);
		return method.invoke(proxied, args);
	}
}

class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		
		// Insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(real));
		consumer(proxy);
	}
} 
