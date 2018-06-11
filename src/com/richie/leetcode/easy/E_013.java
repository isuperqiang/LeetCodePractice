package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.11
 */
public class E_013 {
    /**
     * 最长公共前缀
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-common-prefix/description/
     * </p>
     *
     * <p>
     * 描述：编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * </p>
     *
     * <p>
     * 解答：首先确定字符数组中最短的字符串长度，然后遍历字符串，逐个比较相同索引位置的字符是否相同，从而找到公共前缀
     * </p>
     */

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        String ret = longestCommonPrefix(s);
        System.out.println(ret);
        // fl
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        int length = strs.length;
        int index = 0;
        String first = strs[0];
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) != first.charAt(i)) {
                    return first.substring(0, index);
                }
            }
            index++;
        }
        return first.substring(0, index);
    }
}
