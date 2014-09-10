package innerclass;

class Fruit{
	private int a=3;
	public class Apple{//成员内部类相当于非成员成员变量
		private int a=5;
		public void test(){
			System.out.println(Fruit.this.a);//对外部类成员变量的访问
		}
		public void function(){
			Apple apple=new Apple();//在enclosing class中生成内部类对象的方式
			//Apple apple=this.new Apple();
		}
	}
}


public class MemberInnerClass {
	public static void main(String[] args) {
		Fruit.Apple apple=new Fruit().new Apple();
		apple.test();
	}

}
