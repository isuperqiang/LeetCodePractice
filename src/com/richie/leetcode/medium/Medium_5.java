package com.richie.leetcode.medium;

/**
 * @author richie on 2018.05.29
 */
public class Medium_5 {
    /**
     * 最长回文子串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-palindromic-substring/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * </p>
     *
     * <p>
     * 解答：中心扩展法
     * 由于回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+(n-1) 个中心。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String s = "12321";
        String palindrome = longestPalindrome(s);
        System.out.println(palindrome);
        // 输出 12321
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
