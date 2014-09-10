package generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Generic<T> {
	private T element;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	public static void main(String[] args) {
		Generic<? extends List> g=null;//通用类型声明
		g=new Generic<LinkedList>();
		g=new Generic<ArrayList>();
		
		Generic<String> g2=new Generic<String>();
		g2.setElement("hello vonzhou");
//		Generic<? extends Object> g3=g2;
		Generic<?> g3=g2;
		System.out.println(g3.getElement());
		
		g3.setElement(null);
		//g3只能查看或者移除其所参照的实例信息，不能增加信息。
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
