package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.18
 */
public class Easy_557 {
    /**
     * 反转字符串中的单词 III
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
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
     * 解答：
     * 从头遍历字符串，遇到空格就把之前的单词反转，然后跳过空格继续遍历，每次遍历处理一个单词。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String ans = new Easy_557().reverseWords(str);
        System.out.println(ans);
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = s.length();
        while (i < len) {
            int start = i;
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = i - 1; j >= start; j--) {
                sb.append(s.charAt(j));
            }
            while (i < len && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
