package annotation;

public @interface AnnotationTest {
	String value1() default "hello";
	EnumTest value2();

}

enum EnumTest{
	Hello,Hi,Welcome;
}
