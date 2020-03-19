package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author Richie on 2020.03.19
 */
public class Easy_409 {
    /**
     * 最长回文串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-palindrome/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * </p>
     *
     * <p>
     * 解答：
     *
     * </p>
     */

    public static void main(String[] args) {
        String input = "abccccdd"; // dccaccd
        int longestPalindrome = longestPalindrome(input);
        System.out.println("result: " + longestPalindrome);
    }

    private static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int result = 0;
        for (int i = 1, len = chars.length; i < len; ) {
            if (chars[i - 1] == chars[i]) {
                result += 2;
                i += 2;
            } else {
                i++;
            }
        }
        if (result < chars.length && result % 2 == 0) {
            result += 1;
        }
        return result;
    }

}
