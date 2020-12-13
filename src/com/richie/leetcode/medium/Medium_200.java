package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.13
 */
public class Medium_200 {
    /**
     * 岛屿数量
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/number-of-islands/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * </p>
     *
     * <p>
     * 解答：DFS 或者 BFS
     * 上下左右相连的 1 都被认为是连续岛屿。
     * 指定岛屿的某点 (i,j)，从该点向上下左右做深度搜索，终止条件是指针越界或超过岛屿边界。
     * 遍历的同时修改岛屿的标记，避免后面重复计算，递归完成后累加岛屿的数量。
     * </p>
     *
     * <p>
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     * </p>
     */

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int ans = new Medium_200().numIslands(grid);
        System.out.println(ans);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0, row = grid.length; i < row; i++) {
            for (int j = 0, col = grid[0].length; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
