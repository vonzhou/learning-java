package algrithm.sedgewick.strings;

/**
 * 11.Subsequence. 
 * Given two strings s and t, write a program Subsequence.java that determines 
 * whether s is a subsequence of t. That is, the letters of s should appear in 
 * the same order in t, but not necessarily contiguously. For example accag is 
 * a subsequence of taagcccaaccgg.
 * 模式匹配 ？？
 * 
 * 注意：说了不要求连续出现，否则的话这个方法行不通
 */
public class Subsequence { 
    public static boolean isSubsequence(String s, String t) {
        int M = s.length();
        int N = t.length();

        int i = 0;
        for (int j = 0; j < N; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
            if (i == M) return true;
        }
        return false;
    }

    public static void main(String[] args) { 
        String s = "bcd";
        String t = "baaaacd";
        System.out.println(isSubsequence(s, t));
    }

}
