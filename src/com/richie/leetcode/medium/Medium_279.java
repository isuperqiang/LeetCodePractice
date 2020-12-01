package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.10.20
 */
public class Medium_279 {
    /**
     * 完全平方数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/perfect-squares/
     * </p>
     *
     * <p>
     * 描述：
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * </p>
     *
     * <p>
     * 解答：动态规划
     * - dp[i] 表示和为 i 需要最少完全平方数的个数，dp[] 大小为 n+1
     * - 初始化 dp[] 为最大值，dp[0]=0
     * - 状态转移方程，dp[i]=min(dp[i], dp[i-j*j] + 1)，表示两者取最小值，选择 j 使用一个数，剩下取决于 dp[i-j*j]
     * - dp[n] 就是结果
     * </p>
     *
     * <p>
     * 时间复杂度：O(n*sqrt(n))
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int i = new Medium_279().numSquares(12);
        System.out.println(i); // 3
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
