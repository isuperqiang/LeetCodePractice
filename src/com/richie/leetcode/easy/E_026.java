package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.30
 */
public class E_026 {
    /**
     * 爬楼梯
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/climbing-stairs/description/
     * </p>
     *
     * <p>
     * 描述：假设你正在爬楼梯。需要 n 步你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * </p>
     *
     * <p>
     * 解答：本质是一个斐波那契数列问题。可以使用递归或者迭代解决。
     * </p>
     */

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
        // 3
    }

    private static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 1;
        int b = 1;
        int r = 0;
        for (int i = 2; i <= n; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }
}
