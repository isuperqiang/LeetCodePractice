package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.01
 */
public class Medium_151 {
    /**
     * 翻转字符串里的单词
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 无空格字符构成一个 单词 。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * </p>
     *
     * <p>
     * 示例：
     * 输入："the sky is blue"
     * 输出："blue is sky the"
     * </p>
     *
     * <p>
     * 解答：双指针
     * - 倒序遍历字符串 s ，记录单词左右索引边界 i, j;
     * - 每次遍历会根据边界确定一个单词，则将其添加至单词列表;
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        String words = new Medium_151().reverseWords("the sky is blue");
        System.out.println(words);
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
