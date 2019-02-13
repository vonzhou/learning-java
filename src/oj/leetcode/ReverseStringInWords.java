package oj.leetcode;

import java.util.StringTokenizer;

/**
 * 151. Reverse Words in a String
 */
public class ReverseStringInWords {

    /**
     * AC
     * 1.直接使用API
     * 耗时420ms
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";

        // split() 会包含字符串开头的空串
        String arr[] = s.split(" ");
        if (arr.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals(""))
                sb.append(arr[i]).append(" ");
        }

        // 去掉最后一个空格
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    /**
     * 2.
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreElements()) {
            sb.insert(0, st.nextElement() + " ");
        }
        String result = sb.toString();
        //System.out.println(result);
        if (result.length() <= 0)
            return "";
        else return result.substring(0, result.length() - 1);
    }

    /**
     * 3. 不用现成的API
     * 耗时5ms
     */
    public String reverseWords3(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ')
                i++; // skip spaces
            while (j < i || j < n && a[j] != ' ')
                j++; // skip non spaces

            // reverse the word
            reverse(a, i, j - 1);
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public static void main(String[] args) {
        String s = "   rwerqwe vwrtqw3 c  ";
        String arr[] = s.split(" ");
        for (int i = 0; i < arr.length; i++)
            System.out.println("=" + arr[i] + "=");
        String s2 = "the sky is blue";
        System.out.println(new ReverseStringInWords().reverseWords2(s2) + "=");
    }
}
