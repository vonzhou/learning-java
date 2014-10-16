package algrithm.sedgewick.search.hashtable;

public class TestString {
	public static void main(String[] args) {
		String s = "polygenelubricants";
		
		System.out.println(s.hashCode());
		System.out.println(s.hashCode() == Integer.MIN_VALUE);
		
		Float f = Float.NaN;
		Float f1  = 3.14f;
		Float f2  = 3.14f;
		System.out.println(Float.toHexString(f));
		System.out.println(f.hashCode());
		System.out.println(f1 == f2); //false 所以对于浮点数不能用等号来判断

	}

}
