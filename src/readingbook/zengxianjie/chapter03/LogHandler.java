package readingbook.zengxianjie.chapter03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LogHandler implements InvocationHandler{
	Object obj;
	public LogHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.doBefore();
		Object res = method.invoke(obj, args);
		this.doAfter();
		return res;
	}

	private void doAfter() {
		System.out.println("Some thing after ...");
	}

	private void doBefore() {
		System.out.println("Some thing before ...");
	}

}
