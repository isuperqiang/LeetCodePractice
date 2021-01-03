package com.richie.leetcode.offer;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_15 {
    /**
     * 二进制中 1 的个数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * 输入必须是长度为 32 的 二进制串 。
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
     * 和题目 191 相同
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int ans = new Offer_15().hammingWeight(0b00000000000000000000000000001011);
        System.out.println(ans);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }
}
