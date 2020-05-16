package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.05.15
 */
public class Medium_518 {
    /**
     * 零钱兑换 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/coin-change-2/
     * </p>
     *
     * <p>
     * 描述：
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * </p>
     *
     * <p>
     * 解答：
     * 动态规划: dp[i][j] 表示只使用前 i 个硬币凑成金额 j 的组合数。如果不使用 coins[i-1]，dp[i][j] 等于 dp[i-1][j]；
     * 如果使用，dp[i][j] 等于 dp[i][j-coins[i-1]]。最终 dp[i][j] 等于两者之和。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N*M)，N 为硬币个数，M 为金额数
     * 空间复杂度：O(N*M)
     * </p>
     */

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = change(5, coins);
        System.out.println(i); // 4
    }

    private static int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][amount];
    }

}
