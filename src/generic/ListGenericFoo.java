package generic;

import java.util.LinkedList;
import java.util.List;
//限制参数T继承某个类或实现某个接口，要用关键字extends
//当没有参数化T时，默认T extends Object
public class ListGenericFoo<T extends List<String>> {
	private T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}
	
	public static void main(String[] args) {
		ListGenericFoo<LinkedList<String>> foo1=new ListGenericFoo<LinkedList<String>>();
		LinkedList<String> list=new LinkedList<String>();
		foo1.setFoo(list);
	}

}
