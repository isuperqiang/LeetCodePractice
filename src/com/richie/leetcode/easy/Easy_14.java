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
     * 解答：首先确定字符串数组中最短的字符串长度，作为最长公共前缀的限制长度。然后取第一个字符串作为基准，遍历其余的字符串，
     * 逐个比较相同索引位置的字符是否相同，从而找到公共前缀。
     * </p>
     *
     * <p>
     * 时间复杂度：O(mn)
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
        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        int index = 0;
        String first = strs[0];
        out:
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != first.charAt(i)) {
                    break out;
                }
            }
            index++;
        }
        return first.substring(0, index);
    }
}
