package readingbook.apressjavacollections.chapter2;

import java.util.Arrays;

public class CloneArray {
  public static void main (String args[]) {
    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int array1s[] = null;
    System.out.println("Original size: " + array1.length);
    array1s = cloneArray(array1);
    System.out.println(Arrays.equals(array1, array1s));
    array1[0] = 100;
    System.out.println("New size: " + array1s.length);
    System.out.println("New element 0 : " + array1s[0]);//因为这是基本类型的数组clone
    // 如果是对象数组的话，克隆的仅仅是引用，指向的是相同的基本对象
    
    System.out.println("Original size: " + array2.length);
    System.out.println("New size: " + cloneArray(array2).length);
  }
  static int[] cloneArray(int original[]) {
    return (int[])original.clone();
  }
}