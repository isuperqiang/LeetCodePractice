package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.07
 */
public class Easy_28 {
    /**
     * 实现strStr()
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/implement-strstr/description/
     * </p>
     *
     * <p>
     * 描述：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * </p>
     *
     * <p>
     * 解答：开始遍历母字符串，并不需要遍历整个母字符串，而是遍历到剩下的长度和子字符串相等的位置即可，这样可以提高运算效率。
     * 然后对于每一个字符，我们都遍历一遍子字符串，一个一个字符的对应比较。如果对应位置有不等的，则跳出循环；
     * 如果一直都没有跳出循环，则说明子字符串出现了，则返回起始位置即可。
     * </p>
     */

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int index = strStr(haystack, needle);
        System.out.println(index);
        // 2
    }

    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int nlen = needle.length();
        if (nlen == 0) {
            return 0;
        }

        int len = haystack.length();
        if (nlen > len) {
            return -1;
        }

        for (int i = 0; i <= len - nlen; i++) {
            for (int j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == nlen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
