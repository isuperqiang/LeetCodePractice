package com.richie.leetcode.easy;

/**
 * @author richie on 2018.05.29
 */
public class E_002 {

    /**
     * 反转字符串
     *
     * <P>
     * 地址：https://leetcode-cn.com/problems/reverse-string/description/
     * </P>
     *
     * <p>
     * 描述：请编写一个函数，其功能是将输入的字符串反转过来。
     * </p>
     *
     * <p>
     * 解答：遍历字符数组，然后依次交换前后的位置
     * </p>
     */

    public static void main(String[] args) {
        String s = "hello";
        String re = reverseString(s);
        System.out.println(re);
        // 输出：olleh
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }
        return new String(chars);
    }
}
