package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.07.02
 */
public class E_028 {

    /**
     * 旋转图像
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/rotate-image/description/
     * </p>
     *
     * <p>
     * 描述：给定一个 n × n 的二维矩阵表示一个图像，将图像顺时针旋转 90 度。
     * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * </p>
     *
     * <p>
     * 解答：首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果
     * </p>
     */

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        // [
        //  [1, 2, 3]
        //  [4, 5, 6]
        //  [7, 8, 9]
        // ]
        rotate(matrix);
        printMatrix(matrix);
        // [
        //  [7, 4, 1]
        //  [8, 5, 2]
        //  [9, 6, 3]
        // ]
    }

    private static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int length = matrix.length;
        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }
        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("[");
        for (int[] ints : matrix) {
            System.out.println("  " + Arrays.toString(ints));
        }
        System.out.println("]");
    }
}
