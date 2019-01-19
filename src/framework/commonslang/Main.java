package framework.commonslang;

import org.apache.commons.lang.StringUtils;

/**
 * @version 2017/7/28.
 */
public class Main {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(StringUtils.substring(s, 0, 10) + "|");
    }
}
