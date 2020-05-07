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
     * 说明: 你算法的时间复杂度应为 O(log n) 。
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
     * 解答：只有 2 * 5 末尾才有零，乘数中 2 的个数肯定比 5 多，只要统计乘数里因子 5 的个数就行了。
     * 同时注意 5 的幂数存在多个 5，最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
     * </p>
     *
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int i = trailingZeroes(20);
        System.out.println(i); // 4
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
