package oj.leetcode;


/**
 * 567. Permutation in String
 * Created by vonzhou on 2019/2/13.
 */
public class PermutationInString {

    /**
     * AC
     * 耗时 8ms
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;

        int left = 0, right = 0, count = s1.length();

        int[] map = new int[256];


        for (char c : s1.toCharArray())
            map[c]++;

        char[] sc = s2.toCharArray();
        while (right < s2.length()) {
            // 每一轮都会推进窗口的右边界
            if (map[sc[right++]]-- >= 1)
                count--;
            // 区间 [left, right] 包含了p中所有字符
            if (count == 0)
                return true;
            // 经历了前面--， 如果map[leftChar]仍然>=0，说明一个符合条件的字符即将移出窗口，count++
            // 每一轮都会滑动窗口的右边界right，但是只有当窗口大于p长度时，会移动窗口的左边界left
            if (right - left == s1.length() && map[sc[left++]]++ >= 0)
                count++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));

        s2 = "eidboaoo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }
}
