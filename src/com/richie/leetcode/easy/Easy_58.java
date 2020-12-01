package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.10
 */
public class Easy_58 {
    /**
     * 最后一个单词的长度
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/length-of-last-word/
     * </p>
     *
     * <p>
     * 描述：给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * </p>
     *
     * <p>
     * 解答：
     * - 解法一：按照空格分割字符串，然后找到最后一个单词，返回长度
     * - 解法二：从后向前遍历字符串，然后统计最后一个单词的长度
     * </p>
     */
    public static void main(String[] args) {
        String s = "Hello World";
        int i = lengthOfLastWord2(s);
        System.out.println(i); // 5
    }

    private static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] split = s.split(" ");
        int length = 0;
        if (split.length > 0) {
            length = split[split.length - 1].trim().length();
        }
        return length;
    }

    private static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
