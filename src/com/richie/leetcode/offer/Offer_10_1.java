package com.richie.leetcode.offer;

/**
 * @author Richie on 2021.01.05
 */
public class Offer_10_1 {
    /**
     * 斐波那契数列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * F(0) = 0, F(1)  = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：n = 5
     * 输出：5
     * </p>
     *
     * <p>
     * 解答：
     * 动态规划，注意取余。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int ans = new Offer_10_1().fib(45);
        System.out.println(ans);
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
