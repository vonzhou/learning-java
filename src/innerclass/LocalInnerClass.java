package innerclass;

class A{
	public void function1(){
		final int a=90;//
		class B{//局部内部类 定义在方法当中，只能访问final 的成员变量
			//局部内部类没有public等的修饰，如同局部变量一样
			public void function2(){System.out.println(a);} 
		}
		new B().function2();
	}
}

public class LocalInnerClass {
	public static void main(String[] args) {
		new A().function1();
	}

}
