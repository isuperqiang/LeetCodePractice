package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.26
 */
public class Easy_191 {
    /**
     * 位1的个数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/number-of-1-bits/description/
     * </p>
     *
     * <p>
     * 描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
     * </p>
     *
     * <p>
     * 解答：先把整数转换成二进制字符串，然后统计 1 的个数。
     * </p>
     */

    public static void main(String[] args) {
        int count = hammingWeight(11);
        System.out.println(count);
        // 输入: 11
        // 输出: 3
        // 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
    }

    // you need to treat n as an unsigned value
    private static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }

}
