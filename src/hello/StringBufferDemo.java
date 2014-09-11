package hello;

 class A {
	public static void test(StringBuffer a, StringBuffer b){
		a.append(b);
		a = b;
	}
}
public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer sa = new StringBuffer("A");
		StringBuffer sb = new StringBuffer("B");
		A.test(sa, sb);
		System.out.println(sa + "   "+sb);
	}

}
