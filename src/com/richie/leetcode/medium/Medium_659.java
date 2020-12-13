package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.13
 */
public class Medium_659 {
    /**
     * 岛屿的最大面积
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/max-area-of-island/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     * * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     * </p>
     *
     * <p>
     * 示例：
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     * </p>
     *
     * <p>
     * 解答：DFS
     * 指定岛屿的某点 (i,j)，从该点向上下左右做深度搜索，终止条件是指针越界或超过岛屿边界。
     * 遍历的同时修改岛屿的标记，避免后面的重复计算，递归完成后更新最大面积。
     * </p>
     *
     * <p>
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     * </p>
     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int ans = new Medium_659().maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, row = grid.length; i < row; i++) {
            for (int j = 0, col = grid[0].length; j < col; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, row, col, i, j);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, row, col, i - 1, j) + dfs(grid, row, col, i + 1, j)
                + dfs(grid, row, col, i, j - 1) + dfs(grid, row, col, i, j + 1);
    }
}
