package lang;

import java.math.BigDecimal;

/**
 * @version 2018/2/2.
 */
public class ComparableDemo {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("4.00");
        BigDecimal d2 = new BigDecimal("4.0");
        BigDecimal d3 = new BigDecimal("0.123");


        System.out.println(d1.compareTo(d2)); // 0
        System.out.println(d1.equals(d2)); // false

    }
}
