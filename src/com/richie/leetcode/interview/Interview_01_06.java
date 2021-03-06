package com.richie.leetcode.interview;

/**
 * @author Richie on 2020.12.02
 */
public class Interview_01_06 {
    /**
     * 字符串压缩
     *
     * <p>
     * 链接：
     * </p>
     *
     * <p>
     * 描述：
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * </p>
     *
     * <p>
     * 示例：
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * </p>
     *
     * <p>
     * 解答：
     * 按照题目要求，定义 count 记录每个字符出现的次数，当相邻两个字符不相等时，追加次数，并重置为 1。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        String ans = new Interview_01_06().compressString("aabcccccaaa");
        System.out.println(ans);
    }

    public String compressString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        ans.append(chars[0]);
        int count = 1;
        int length = s.length();
        for (int i = 0, len = length - 1; i < len; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                ans.append(count);
                count = 1;
                ans.append(chars[i + 1]);
            }
        }
        ans.append(count);
        return ans.length() < length ? ans.toString() : s;
    }
}
