package annotation;

@AnnotationTest(value2=EnumTest.Hello)
public class AnnotationUsage {
	
	@AnnotationTest(value1="vonzhou",value2=EnumTest.Hi)
	public void method(){
		System.out.println("use annotation!");
	}
	
	public static void main(String[] args) {
		AnnotationUsage a=new AnnotationUsage();
		a.method();
	}

}
