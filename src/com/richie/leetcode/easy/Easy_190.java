package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.05.07
 */
public class Easy_190 {
    /**
     * 颠倒二进制位
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-bits/
     * </p>
     *
     * <p>
     * 描述：颠倒给定的 32 位无符号整数的二进制位。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     * </p>
     *
     * <p>
     * 解答：逐位颠倒
     * 从右向左遍历二进制串，用 n&1 取得最右一位，然后左移该值到对应位置，和结果值求和，退出条件是 n == 0
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        int i = reverseBits(n);
        System.out.println(i);
    }

    // you need treat n as an unsigned value
    private static int reverseBits(int n) {
        int ret = 0;
        for (int bitsSize = 31; n != 0; bitsSize--) {
            ret += (n & 1) << bitsSize;
            n = n >>> 1;
        }
        return ret;
    }
}
