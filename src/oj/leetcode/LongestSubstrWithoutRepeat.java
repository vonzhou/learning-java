package oj.leetcode;

import java.util.*;

/**
 * 3.https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstrWithoutRepeat {

    /**
     * AC
     * 1.Brute,复杂度O(N^2)
     * 因为是求最大的长度，所以不需要开辟太多的空间
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();

        int R = 256;

        int M = 0;  // 记录无重复子串的最大长度
        int N = s.length();
        for (int i = 0; i < N; i++) {
            boolean[] exist = new boolean[R];
            int len = 0;
            for (int j = i; j < N; j++) {
                if (exist[s.charAt(j)])
                    break;
                len++;
                exist[s.charAt(j)] = true;
            }
            if (len > M)
                M = len;
        }
        return M;
    }

    /**
     * AC
     * 2.和方法一一样, Runtime: 82 ms, Memory Usage: 40.4 MB
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();

        int M = 0;  // current length
        int N = s.length();
        for (int i = 0; i < N; i++) {
            HashSet hash = new HashSet();
            int len = 0;
            for (int j = i; j < N; j++) {
                if (hash.contains(s.charAt(j)))
                    break;
                len++;
                hash.add(s.charAt(j));
            }
            if (len > M)
                M = len;
        }
        return M;
    }

    /**
     * 3. 利用HashMap
     * XXX 转载的
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }


        return max;
    }

    /**
     * AC
     * 基于队列的滑动窗口,Runtime: 47 ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            // 如果队列中有和当前字符重复的,就向后滑动
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abcabcbb", "bbbbb", "pwwkew");
        list.stream().forEach(s -> {
            System.out.println(new LongestSubstrWithoutRepeat().lengthOfLongestSubstring4(s));
        });

    }
}



















