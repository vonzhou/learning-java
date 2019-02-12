package oj.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    /**
     * 1. 能直接想到的, 复杂度O(M*N),M是字符串的长度,N字符串的个数
     * Runtime: 576 ms
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        // 空数组要单独考虑 strs = {};
        if (strs.length == 1)
            return strs[0];

        // to look up the min len
        int min = Integer.MAX_VALUE;
        for (String s : strs)
            if (s.length() < min)
                min = s.length();
        if (min == 0)
            return "";
        //再次强调break只能中断一层循环
        int i = 0;
        loop:
        for (i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
                if (strs[j].charAt(i) != c)
                    break loop;
        }

        return strs[0].substring(0, i);
    }

    /**
     * 2. 理论上复杂度也是O(M*N),为啥快了很多?
     * 耗时4 ms
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    /**
     * 3. indexOf 换成 startsWith,也是一样的
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (!strs[i].startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    /**
     * 4.依次找2个字符串的最长前缀
     * 和2,3耗时一样的
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1) {
            return strs[0];
        }

        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            common = longestCommonPrefixOfTwo2(common, strs[i]);
        }
        return common;

    }

    private String longestCommonPrefixOfTwo(String common, String str) {
        String pre = common;
        while (!str.startsWith(pre))
            pre = pre.substring(0, pre.length() - 1);
        return pre;
    }

    /**
     * 耗时6ms,多了一点点
     */
    private String longestCommonPrefixOfTwo2(String common, String str) {
        int min = Math.min(common.length(), str.length());
        int i = 0;
        while (i < min) {
            if (common.charAt(i) != str.charAt(i)) {
                break;
            }
            i++;
        }
        return common.substring(0, i);
    }


    public static void main(String[] args) {
//        String ss[] = {"flower", "flow", "flight"};
        String ss[] = {"c", "c"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix4(ss));
    }
}
