package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Richie on 2020.12.02
 */
public class Medium_54 {
    /**
     * 螺旋矩阵
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/spiral-matrix/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * </p>
     *
     * <p>
     * 解答：
     *
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list = new Medium_54().spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //todo
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        return result;
    }
}
