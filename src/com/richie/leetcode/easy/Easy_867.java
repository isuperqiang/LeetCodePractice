package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author Richie on 2020.11.19
 */
public class Easy_867 {
    /**
     * 转置矩阵
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/transpose-matrix/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * </p>
     *
     * <p>
     * 解答：
     * 大小为 row*col 的矩阵，转置后得到 col*row 的矩阵，因此有 ans[col][row] = A[row][col]
     * </p>
     *
     * <p>
     * 时间复杂度：O(r*c)
     * 空间复杂度：O(r*c)
     * </p>
     */

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = new Easy_867().transpose(a);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
