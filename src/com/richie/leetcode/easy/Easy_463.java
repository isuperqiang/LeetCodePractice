package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.12.13
 */
public class Easy_463 {
    /**
     * 岛屿的周长
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/island-perimeter/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
     * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     * 输出：16
     * 解释：它的周长是上面图片中的 16 个黄色的边
     * </p>
     *
     * <p>
     * 解答：DFS
     * 岛屿和网格边界会产生一个长度，岛屿和水域边界也会产生一个长度，岛屿之间没有长度，所以深度优先搜索，记录网格边界和水域边界的长度和即可。
     * </p>
     *
     * <p>
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     * </p>
     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int ans = new Easy_463().islandPerimeter(grid);
        System.out.println(ans);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0, row = grid.length; i < row; i++) {
            for (int j = 0, col = grid[0].length; j < col; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, row, col, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, row, col, i - 1, j) + dfs(grid, row, col, i + 1, j)
                + dfs(grid, row, col, i, j - 1) + dfs(grid, row, col, i, j + 1);
    }
}
