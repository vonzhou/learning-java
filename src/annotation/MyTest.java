package annotation;

@MyAnnotation(world="wuhan")
public class MyTest {
	
	@MyAnnotation(hello="shiyan",world="yunxian")
	@SuppressWarnings("unchecked")
	@Deprecated
	public void output(){
		System.out.println("决战琼华之颠！");
	}

}
