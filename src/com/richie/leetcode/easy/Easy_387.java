package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.01
 */
public class Easy_387 {
    /**
     * 字符串中的第一个唯一字符
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * </p>
     *
     * <p>
     * 解答：逐个遍历字符串，使用两层循环，找到不重复的就返回，否则继续下一个
     * </p>
     */
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
        // 输出：2
    }

    private static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            boolean repeat = false;
            for (int j = 0; j < len; j++) {
                if (i != j && chars[i] == chars[j]) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                return i;
            }
        }
        return -1;
    }
}
