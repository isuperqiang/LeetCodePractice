package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.04.01
 */
public class Easy_01_04 {
    /**
     * 回文排列
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/palindrome-permutation-lcci/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     * </p>
     *
     * <p>
     * 示例：
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     * </p>
     *
     * <p>
     * 解答：
     * 利用回文字符串的定义：每个字符出现的次数为偶数, 或者有且仅有一个字符出现的次数为奇数时, 是回文的排列。
     * count 记录出现次数为奇数的字符的个数，如果出现奇数次 count++，否则 count--，结果就是奇数次 <= 1
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        boolean result = canPermutePalindrome("tacocat");
        System.out.println(result); // true
    }

    private static boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int[] charCount = new int[256];
        int count = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            if ((++charCount[c] & 1) == 1) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;
    }
}
