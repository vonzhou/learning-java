package innerclass;

import java.util.Date;
/**
 * 匿名内部类重要特征：  Implicitly extends a class or implements a interface
 * @author vonzhou
 *
 */
public class AnonymousInnerClass {
	
	@SuppressWarnings("deprecation")
	public void get(Date date){
		System.out.println(date.toLocaleString());
	}
	
	public static void main(String[] args) {
		new AnonymousInnerClass().get(new Date(){
		//生成了一个继承自Date类的匿名内部类的对象
	    //可以重写父类的方法
			public String toLocaleString(){
				return "当前系统时间是："+super.toLocaleString();
			}
		});
	}

}
