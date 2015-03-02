package algrithm.sedgewick.strings.tries;

public class StringBuilderTest {
	public static void func(StringBuilder sb){
		sb.append("aaaaaaaaaaaaaaaa");
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("vonzhou");
		sb.deleteCharAt(3);
		System.out.println(sb);
		func(sb);
		System.out.println(sb);
	}

}
