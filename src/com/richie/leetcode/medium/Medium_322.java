package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.05.15
 */
public class Medium_322 {
    /**
     * 零钱兑换
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/coin-change/
     * </p>
     *
     * <p>
     * 描述：
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * </p>
     *
     * <p>
     * 解答：
     * 动态规划：dp[i] 表示总金额为 i 时至少需要的硬币个数，初始赋值 amount+1 表示不可能取到的值。注意金额要不小于硬币面值，而且保证金额可以被硬币凑出来。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N * k), k 为硬币个数
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = coinChange(coins, 11);
        System.out.println(i); // 3
    }

    private static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int length = amount + 1;
        int[] dp = new int[length];
        Arrays.fill(dp, length);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == length ? -1 : dp[amount];
    }
}
