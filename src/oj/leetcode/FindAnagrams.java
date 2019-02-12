package oj.leetcode;

import java.util.*;

/**
 * Find All Anagrams(变位词) in a String
 * 基本的思路是:遍历s,依次看子串是否是p的变位词,判断是否是变位词就看字符出现的个数是否一样了.
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 看看这个滑动窗口的归纳 https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * <p>
 * <p>
 * Created by vonzhou on 2019/2/12.
 */
public class FindAnagrams {

    /**
     * 1. 耗时161ms
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256];
        List<Integer> pos = new ArrayList<Integer>();

        for (int i = 0; i < pLen; i++) {
            hash[(int) p.charAt(i)]++;
        }
        int i = 0;

        while (i < sLen - pLen + 1) {
            boolean success = true;
            // 深拷贝
            int[] tmpCount = new int[256];
            System.arraycopy(hash, 0, tmpCount, 0, 256);

            for (int j = i; j < i + pLen; j++) {
                if (--tmpCount[(int) s.charAt(j)] < 0) {
                    success = false;
                    break;
                }
            }

            if (success) {
                pos.add(i);
            }
            i++;
        }


        return pos;
    }

    /**
     * 没有理解
     */
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256];
        List<Integer> pos = new ArrayList<Integer>();

        for (int i = 0; i < pLen; i++) {
            hash[(int) p.charAt(i)]++;
        }
        // 记录窗口内字符的个数
        int count = 0;

        while (right < sLen) {
            // right 位置出现了p中的字符
            if (hash[(int) s.charAt(right)] > 0) {
                hash[(int) s.charAt(right)]--;
                count++;
                right++;
            } else {
                hash[(int) s.charAt(left)]++;
                count--;
                left++;
            }

            if (count == pLen) {
                pos.add(left);
            }

        }
        return pos;
    }

    public List<Integer> findAnagrams2(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length())
            return result;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        System.out.println(new FindAnagrams().findAnagrams1(s, p));
    }
}
