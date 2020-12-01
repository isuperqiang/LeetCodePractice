package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.10.13
 */
public class Medium_63 {
    /**
     * 不同路径 II
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * </p>
     *
     * <p>
     * 解答：动态规划
     * 1. 定义 dp[i][j] 表示从左上角到达 [i,j] 的路径数量；
     * 2. 初始化 dp[][]，对于第一行 dp[0][j]，或者第一列 dp[i][0]，考虑路障；
     * 3. 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]，存在路障时为 0；
     * 4. 返回 dp[][] 最后一个元素。
     * </p>
     *
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * </p>
     */

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int i = new Medium_63().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i); // 2
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
