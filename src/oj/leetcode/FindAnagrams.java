package oj.leetcode;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
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
     * 1. 复杂度O（M*N）？
     * 耗时161ms
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
     * AC
     * 2.滑动窗口的思想，复杂度O（M）
     * 耗时7ms
     */
    public List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null)
            return result;

        int left = 0, right = 0, count = p.length();

        int[] map = new int[256];

        char[] sc = s.toCharArray();

        for (char c : p.toCharArray())
            map[c]++;

        while (right < s.length()) {
            // 每一轮都会推进窗口的右边界
            if (map[sc[right++]]-- >= 1)
                count--;
            // 区间 [left, right] 包含了p中所有字符
            if (count == 0)
                result.add(left);
            // 经历了前面--， 如果map[leftChar]仍然>=0，说明一个符合条件的字符即将移出窗口，count++
            // 每一轮都会滑动窗口的右边界right，但是只有当窗口大于p长度时，会移动窗口的左边界left
            if (right - left == p.length() && map[sc[left++]]++ >= 0)
                count++;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        System.out.println(new FindAnagrams().findAnagrams2(s, p));
    }
}
