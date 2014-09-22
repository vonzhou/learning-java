package readingbook.apressjavacollections.chapter8;


interface A{
	void f();
}

class B implements A{
	public void f(){
		System.out.println("invoked f in B");
	}
}

class C extends B{
	public void f(){
		System.out.println("invoked f in C");
	}
}


public class ObjectDemo {
	
}
