package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author Richie on 2020.12.02
 */
public class Medium_54 {
    //    输入:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    输出: [1,2,3,6,9,8,7,4,5]
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
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        return result;
    }
}
