package com.richie.leetcode.offer;

/**
 * @author Richie on 2021.01.05
 */
public class Offer_10_2 {
    /**
     * 青蛙跳台阶问题
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：n = 2
     * 输出：2
     * </p>
     *
     * <p>
     * 解答：
     * 和题目 70 一样，这里使用动态规划解决。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int ans = new Offer_10_2().numWays(3);
        System.out.println(ans);
    }

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
