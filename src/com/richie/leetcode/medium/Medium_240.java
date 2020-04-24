package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.04.24
 */
public class Medium_240 {
    /**
     * 搜索二维矩阵 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * </p>
     *
     * <p>
     * 示例：
     * 现有矩阵 matrix 如下：
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     * </p>
     *
     * <p>
     * 解答：
     * 从左下角出发，把 target 和当前值比较。如果 target 大于当前值，就往右走；如果小于，就往上走。如果等于，就返回 true。
     * </p>
     *
     * <p>
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = searchMatrix(matrix, 5);
        System.out.println(b);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        int columnLength = matrix[0].length;
        while (row >= 0 && column < columnLength) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }
}
