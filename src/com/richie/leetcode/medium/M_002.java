package com.richie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richie on 2018.07.13
 */
public class M_002 {
    /**
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
     * </p>
     *
     * <p>
     * 描述：无重复字符的最长子串
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * 示例：
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
     * </p>
     *
     * <p>
     * 解答：
     * 滑动窗口，使用 map记录自字符的索引
     * http://www.lpnote.com/2017/09/08/leetcode-3-longest-substring-without-repeating-characters/
     * </p>
     */

    public static void main(String[] args) {
        String s = "abcabca";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
        // 3
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int maxLen = 0;
        // {char:index}
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(s.charAt(j), j++);
        }
        return maxLen;
    }
}
