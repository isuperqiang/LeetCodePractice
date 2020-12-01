package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.26
 */
public class Easy_191 {
    /**
     * 位 1 的个数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits/
     * </p>
     *
     * <p>
     * 描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
     * </p>
     *
     * <p>
     * 示例：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * </p>
     *
     * <p>
     * 解答：
     * 遍历整数的 32 位，使用掩码检查每位是否为 1，不断左移掩码，将 1 的个数求和。
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */

    public static void main(String[] args) {
        int count = hammingWeight(0b00000000000000000000000000001011);
        System.out.println(count); // 3
    }

    // you need to treat n as an unsigned value
    private static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

}
