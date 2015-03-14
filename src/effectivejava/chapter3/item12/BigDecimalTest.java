package effectivejava.chapter3.item12;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("1.0");
		BigDecimal bd2 = new BigDecimal("1.00");
		
		System.out.println(bd.equals(bd2));
		System.out.println(bd.compareTo(bd2));
	}

}
