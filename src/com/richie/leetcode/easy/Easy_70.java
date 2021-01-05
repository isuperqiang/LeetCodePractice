package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.30
 */
public class Easy_70 {
    /**
     * 爬楼梯
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/
     * </p>
     *
     * <p>
     * 描述：
     * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * </p>
     *
     * <p>
     * 解答：
     * 本质是斐波那契数列问题，可以用动态规划解决，当然也可以用迭代。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：动态规划 O(N)，迭代 O(1)
     * </p>
     */

    public static void main(String[] args) {
        int ans = new Easy_70().climbStairs2(3);
        System.out.println(ans);
    }

    public int climbStairs(int n) {
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

    public int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
