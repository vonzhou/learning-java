package readingbook.apressjavacollections.chapter2;

import java.lang.reflect.Array;

public class ArrayReflection {
  public static void main (String args[]) {
	  int a[] = {1,3,9};
	  printType(a);
  }
  private static void printType (Object object) {
    Class<?> type = object.getClass();
    if (type.isArray()) {
      Class<?> elementType = type.getComponentType();
      System.out.println("Array of: " + elementType.getSimpleName());
      System.out.println("Array size: " + Array.getLength(object));
    }
  }
}







