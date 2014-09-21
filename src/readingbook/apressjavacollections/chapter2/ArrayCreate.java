package readingbook.apressjavacollections.chapter2;

import java.lang.reflect.Array;
import java.util.Random;

public class ArrayCreate {
  public static void main (String args[]) {
	  	// 创建一个数组
	  	Object array = Array.newInstance(int.class, 3);
    	printType(array);
    	fillArray(array);
    	displayArray(array);
  }
  // 打印這個對象的数组类型和大小
  private static void printType (Object object) {
    Class<?> type = object.getClass();
    if (type.isArray()) {
    	Class<?> elementType = type.getComponentType();
      	System.out.println("Array of: " + elementType);
      	System.out.println("Array size: " + Array.getLength(object));
    }
  }
  // 填充数组
  private static void fillArray(Object array) {
    int length = Array.getLength(array);
    Random generator = new Random(System.currentTimeMillis());
    for (int i=0; i<length; i++) {
    	int random = generator.nextInt();
      	//Sets the value of the indexed component of the specified
      	//array object to the specified int value.
      	Array.setInt(array, i, random);
    }
  }
  private static void displayArray(Object array) {
    int length = Array.getLength(array);
    for (int i=0; i<length; i++) {
    	int value = Array.getInt(array, i);
    	System.out.println("Position: " + i + ", value: " + value);
    }
  }
}