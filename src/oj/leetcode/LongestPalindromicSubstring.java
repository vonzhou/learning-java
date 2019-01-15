package oj.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Created by vonzhou on 2019/1/15.
 */
public class LongestPalindromicSubstring {
    /**
     * 我能想到的暴力法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;
        char[] cs = s.toCharArray();
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j < cs.length; j++) {
                if (isPalindrome(cs, i, j)) {
                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(char[] cs, int start, int end) {
        for (int i = start, j = end; i < j; ++i, --j) {
            if (cs[i] != cs[j]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
