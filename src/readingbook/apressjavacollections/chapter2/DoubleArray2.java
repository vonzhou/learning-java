package readingbook.apressjavacollections.chapter2;

import java.lang.reflect.Array;
public class DoubleArray2 {
  public static void main (String args[]) {
    int array[] = {1, 2, 3, 4, 5};
    System.out.println("Original size: " + array.length);
    System.out.println("New size: " + ((int[])doubleArray(array)).length);
    System.out.println(((int[])doubleArray(array))[1]);
  }
  static Object doubleArray(Object original) {
    Object returnValue = null;
    Class<?> type = original.getClass();
    if (type.isArray()) {
      int length = Array.getLength(original);
      Class<?> elementType = type.getComponentType();
      // 根据数组组件的类型，来扩容
      returnValue = Array.newInstance(elementType, length*2);
      System.arraycopy(original, 0, returnValue, 0, length);
    }
    return returnValue;
  }
}