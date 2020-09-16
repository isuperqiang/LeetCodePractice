package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.11
 */
public class Easy_14 {
    /**
     * 最长公共前缀
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-common-prefix/
     * </p>
     *
     * <p>
     * 描述：编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 所有输入只包含小写字母 a-z 。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * </p>
     *
     * <p>
     * 解答：
     * - 横向扫描：
     * 依次遍历字符串数组中的每个字符串，对于每次遍历到的字符串，更新最长公共前缀。当遍历完所有的字符串后，即可得到字符串数组的最长公共前缀。
     * 如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，不需要继续遍历剩下的字符串，直接返回空串即可。
     * - 纵向扫描：
     * 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同。如果相同则继续比较下一列，如果不同则当前列之前的部分为最长公共前缀。
     * </p>
     *
     * <p>
     * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        String ret = longestCommonPrefix(s);
        System.out.println(ret); // fl
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix(String s1, String s2) {
        int index = 0;
        int minLen = Math.min(s1.length(), s2.length());
        while (index < minLen && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        return s1.substring(0, index);
    }

    private static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int prefixLen = prefix.length();
        int len = strs.length;
        for (int i = 0; i < prefixLen; i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < len; j++) {
                String str = strs[j];
                if (i == str.length() || str.charAt(i) != c) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
}
