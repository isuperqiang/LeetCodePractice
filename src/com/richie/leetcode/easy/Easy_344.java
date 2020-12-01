package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.05.29
 */
public class Easy_344 {

    /**
     * 反转字符串
     *
     * <P>
     * 链接：https://leetcode-cn.com/problems/reverse-string/
     * </P>
     *
     * <p>
     * 描述：请编写一个函数，其功能是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * </p>
     *
     * <p>
     * 解答：遍历字符数组，然后依次交换前后的位置
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Easy_344().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseString(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        for (int i = 0, len = chars.length, half = len / 2; i < half; i++) {
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }
    }
}
