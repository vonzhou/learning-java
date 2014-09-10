package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyReflection {
	public static void main(String[] args) throws Exception{
		MyTest myTest=new MyTest();
		Class<MyTest> c=MyTest.class;
		
		Method method=c.getMethod("output",new Class[]{});
		
		if(method.isAnnotationPresent(MyAnnotation.class)){
			method.invoke(myTest,new Object[]{});
			MyAnnotation myAnnotation=method.getAnnotation(MyAnnotation.class);
			String hello=myAnnotation.hello();
			String world =myAnnotation.world();
			System.out.println(hello+"  :  " +world);
		}
		Annotation[] annotation=method.getAnnotations();
		for(Annotation a:annotation){
			System.out.println(a.annotationType().getName());
		}
		
	}
	

}
