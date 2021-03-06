package com.richie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2018.07.13
 */
public class Medium_3 {
    /**
     * 无重复字符的最长子串
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * </p>
     *
     * <p>
     * 示例：
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
     * </p>
     *
     * <p>
     * 解答：双指针
     * 使用哈希表记录字符的位置，left 表示子串的起始位置，right 表示子串的结束位置。当子串包含重复元素时，起始位置向后移动一位，
     * 每次遍历都要更新子串最大长度。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        String s = "abcabca";
        int length = new Medium_3().lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0, length = s.length(); right < length; right++) {
            char ch = s.charAt(right);
            Integer value = map.get(ch);
            if (value != null) {
                left = Math.max(left, value + 1);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(ch, right);
        }
        return ans;
    }
}
