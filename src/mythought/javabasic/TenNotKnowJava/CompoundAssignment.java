package mythought.javabasic.TenNotKnowJava;

public class CompoundAssignment {
	public static void main(String args[]){
		int i=5;
		long j=8;
		//i = j + i; // ERROR: Type mismatch: cannot convert from long to int
		i += j;
		System.out.println(i);
		
		
		byte b = 10;
		b *= 5.7;
		System.out.println(b); // prints 57

		byte b2 = 100;
		b2 /= 2.5;
		System.out.println(b2); // prints 40

		char ch = '0';
		ch *= 1.1;
		System.out.println(ch); // prints '4'

		char ch2 = 'A';  /// 65 * 1.5 = 97.5, 
		ch2 *= 1.5;
		System.out.println(ch2); // prints 'a'
	}

}
