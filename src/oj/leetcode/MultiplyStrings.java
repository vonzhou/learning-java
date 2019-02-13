package oj.leetcode;

/**
 * 参考了 https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 * Created by vonzhou on 2019/2/13.
 */
public class MultiplyStrings {

    /**
     * AC
     * 耗时14ms
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        int[] slot = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 关键要理解 num1[i] * num[j] 后的乘积的2个digit所在的位置
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + slot[p2];

                slot[p1] += sum / 10;
                slot[p2] = (sum) % 10;
            }
        }

        // 去掉前导的0
        StringBuilder sb = new StringBuilder();
        for (int p : slot)
            if (!(sb.length() == 0 && p == 0))
                sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
        num1 = "123456789";
        num2 = "456000000000000000";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
