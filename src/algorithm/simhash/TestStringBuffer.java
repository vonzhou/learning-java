package algorithm.simhash;

public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				sb.append("1");
			else
				sb.append("0");
		}

		String str = sb.toString();
		System.out.println(str);

	}

}
