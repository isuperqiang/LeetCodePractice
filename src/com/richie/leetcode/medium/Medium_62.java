package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2019.09.09
 */
public class Medium_62 {
    /**
     * 不同路径
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/unique-paths/
     * </p>
     *
     * <p>
     * 描述：
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * </p>
     *
     * <p>
     * 解答：动态规划
     * 1. 定义 dp[i][j] 表示从左上角到达 [i,j] 的路径数量；
     * 2. 初始化 dp[][]，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1；
     * 3. 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]；
     * 4. 返回 dp[][] 最后一个元素。
     * </p>
     *
     * <p>
     * - 时间复杂度：O(m*n)
     * - 空间复杂度：O(m*n)
     * </p>
     */

    public static void main(String[] args) {
        int paths = new Medium_62().uniquePaths2(3, 2);
        System.out.println(paths); // 3
    }

    public int uniquePaths(int m, int n) {
        int[] sum = new int[n];
        Arrays.fill(sum, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[j] += sum[j - 1];
            }
        }
        return sum[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
