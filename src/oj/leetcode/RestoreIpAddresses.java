package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Created by vonzhou on 2019/2/14.
 */
public class RestoreIpAddresses {

    /**
     * AC
     * IP地址是4个字节,点分十进制, 没部分最大是255, 占3位
     * 暴力法, 耗时2ms
     * 有没有更好的方法?
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        String ans;

        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++)
                        if (a + b + c + d == s.length()) {
//                            System.out.println(String.format("%s %s %s %s", a, b, c, d));
                            int A = Integer.valueOf(s.substring(0, a));
                            int B = Integer.valueOf(s.substring(a, a + b));
                            int C = Integer.valueOf(s.substring(a + b, a + b + c));
                            int D = Integer.valueOf(s.substring(a + b + c, a + b + c + d));
                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                                ans = A + "." + B + "." + C + "." + D;
                                // 有可能多出0, 所以再校验
                                if (ans.length() == s.length() + 3)
                                    ret.add(ans);
                            }

                        }

        return ret;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));

        s = "010010";
        System.out.println(s);
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }
}
