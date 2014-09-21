package readingbook.apressjavacollections.chapter2;

public class ArrayArgs2 {
	public static void test(String[] a){
		System.out.println(a.length);
	}
	
	
  public static void main (String args[]) {
	  
	  test(new String[]{"vonzhou","rere  "});
	  
    try {
      int i=0;
      do {
        System.out.println("Arg " + i + ": " + args[i++]);
      } while (true);
    } catch (ArrayIndexOutOfBoundsException ignored) {
    	System.out.println("ArrayIndexOutOfBoundsException");
    }
  }
}