package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.03.29
 */
public class Easy_01_03 {
    /**
     * URL 化
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/string-to-url-lcci/
     * </p>
     *
     * <p>
     * 描述：
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * </p>
     *
     * <p>
     * 示例：
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * </p>
     *
     * <p>
     * 解答：
     * 使用额外的存储空间做字符替换
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */
    public static void main(String[] args) {
        String replaceSpaces = replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        //        String replaceSpaces = replaceSpaces("Mr John Smith    ", 13);
        System.out.println(replaceSpaces); // Mr%20John%20Smith
    }

    private static String replaceSpaces(String s, int length) {
        if (s == null || s.length() == 0 || length <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
