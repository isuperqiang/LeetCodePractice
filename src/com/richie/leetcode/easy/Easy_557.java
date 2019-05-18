package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.18
 */
public class Easy_557 {
    /**
     * 反转字符串中的单词 III
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * </p>
     *
     * <p>
     * 解答：先分割单词，然后逐个反转。
     * </p>
     */

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }

    private static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        String[] split = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s1 : split) {
            char[] chars = s1.toCharArray();
            int half = chars.length / 2;
            for (int i = 0; i < half; i++) {
                int right = chars.length - i - 1;
                char temp = chars[right];
                chars[right] = chars[i];
                chars[i] = temp;
            }
            result.append(new String(chars)).append(' ');
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
}
