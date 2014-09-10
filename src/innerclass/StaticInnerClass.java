package innerclass;


class StaticInner{
	private static int a=4;
	public static class Inner{//静态内部类相当于静态成员变量
		public void function(){
			System.out.println(a);//只能访问enclosing class的静态成员
		}
	}
}

public class StaticInnerClass {
	public static void main(String[] args) {
		//生成静态内部类的对象
		StaticInner.Inner inner=new StaticInner.Inner();
		inner.function();
	}

}
