package mythought.thinking;

import java.util.ArrayList;
import java.util.List;

class Example{
	String str = new String("good");
	char[] ch = {'a', 'b', 'c'};
	
	public void change(String str, char ch[]){
//		this.str = "test ok";
		str = "test ok";
		ch[0] = 'g';
	}
	
	public void changeList(List<String> list){
		list.add("Fuck");
	}
	
	public void changeList2(final List<String> list){
		//list = new ArrayList<String>(); 编译期错误，不能改变对象本身，但是可以改变对象的状态，如增加元素
		list.add("Fuck");
	}
}

public class StringAndCharArr {
	public static void main(String[] args){
		Example ex = new Example();
		ex.change(ex.str, ex.ch);
		
		System.out.print(ex.str + "and");
		System.out.print(ex.ch);
		System.out.println("\n-----------");
		
		List<String> l = new ArrayList<String>();
		l.add("init");
		ex.changeList(l);
		System.out.println(l);
	}

}
