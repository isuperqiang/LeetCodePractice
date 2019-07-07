package com.richie.leetcode.easy;

/**
 * @author Richie on 2019.06.23
 */
public class Easy_242 {
    /**
     * 有效的字母异位词
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/valid-anagram/
     * </p>
     *
     * <p>
     * 描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * </p>
     *
     * <p>
     * 解答：统计 s 中每个字母出现的次数，遍历 t 中的字母减去相应的次数。如果次数小于 0，那么认为是 false。
     * </p>
     */

    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0, size = s.length(); i < size; i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0, size = t.length(); i < size; i++) {
            char c = t.charAt(i);
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
