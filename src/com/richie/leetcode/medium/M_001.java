package com.richie.leetcode.medium;

/**
 * @author richie on 2018.05.29
 */
public class M_001 {

    /**
     * 最长回文子串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-palindromic-substring/description/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * </p>
     *
     * <p>
     * 解答：因为回文字符串是以中心轴为对称的，所以如果我们从下标 i 出发，用 2 个指针向 i 的两边扩展判断是否相等，
     * 那么只需要对 0 到 n-1 的下标都做此操作，就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，
     * 即”abcba”与”abba” 2 种类型，因此需要在代码编写时都做判断。
     * </p>
     */

    public static void main(String[] args) {
        String s = "1221";
        String palindrome = longestPalindrome(s);
        System.out.println(palindrome);
        // 输出 1221
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        // 记录最大子串起始坐标
        int start = 0;
        int end = 0;
        // 以 i 为轴心，j 为长度向两边扩展
        for (int i = 0; i < len; i++) {
            // 奇数, 如 12321
            for (int j = 0; i - j >= 0 && i + j < len; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                if (2 * j + 1 > end - start + 1) {
                    start = i - j;
                    end = i + j;
                }
            }

            // 偶数, 如 1221
            for (int j = 0; i - j >= 0 && i + j + 1 < len; j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
                if (2 * j + 2 > end - start + 1) {
                    start = i - j;
                    end = i + j + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
