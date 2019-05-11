package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.11
 */
public class Easy_172 {
    /**
     * 阶乘后的零
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
     * </p>
     *
     * <p>
     * 描述：给定一个整数 n，返回 n! 结果尾数中零的数量。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * </p>
     *
     * <p>
     * 解答：只有 2 * 5 末尾才有零，乘数中 2 的个数肯定比 5 多。n! 为递减阶乘，只要统计乘数里因子 5 的个数就行了。
     * </p>
     */

    public static void main(String[] args) {
        int i = trailingZeroes(20);
        System.out.println(i); //
    }

    private static int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
