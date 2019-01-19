package util;

import java.text.DecimalFormat;

/**
 * @version 2017/6/30.
 */
public class DecimalLearn {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###0.00");
        System.out.println(decimalFormat.format(44444444442.324351432142));
        long x = 2;
        System.out.println(decimalFormat.format((x * 1.0)/100));
    }
}
