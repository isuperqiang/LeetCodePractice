package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.23
 */
public class Medium_64 {
    /**
     * 最小路径和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/minimum-path-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     * </p>
     *
     * <p>
     * 解答：动态规划
     * 1. 定义 dp[i][j] 表示从左上角到点 [i,j] 到最短路径和；
     * 2. 初始化 dp[0,0]=grid[0][0]；
     * 3. 对于第一行 dp[0][j]=dp[0][j-1]+grid[0][j]，对于第一列 dp[i,0]=dp[i-1][0]+grid[i][0]，除此之外 dp[i,j]=min(dp[i-1,j],dp[i,j-1])+grid[i,j]
     * 4. 返回 dp[][] 最后一个元素
     * 优化方案：从左上到右下遍历 grid 数组后，遍历过到位置不再访问，可以覆盖 grid 数组，把它当作 dp 使用。
     * </p>
     *
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * </p>
     */

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minPathSum = minPathSum(grid);
        System.out.println(minPathSum); // 7
    }

    private static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
