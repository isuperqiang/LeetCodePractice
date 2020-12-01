package com.richie.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richie on 2019.05.14
 */
public class Easy_118 {
    /**
     * 杨辉三角
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/pascals-triangle/
     * </p>
     *
     * <p>
     * 描述：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     * </p>
     *
     * <p>
     * 解答：先生成第一行和第二行，之后的行通过上一行计算。
     * </p>
     */

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);
        System.out.println(lists);
    }

    private static List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> triangle = new ArrayList<>(numRows);
        List<Integer> firstRows = new ArrayList<>(1);
        firstRows.add(1);
        triangle.add(firstRows);
        if (numRows >= 2) {
            List<Integer> secondsRows = new ArrayList<>(2);
            secondsRows.add(1);
            secondsRows.add(1);
            triangle.add(secondsRows);
        }

        List<Integer> currentRows;
        for (int i = 2; i < numRows; i++) {
            List<Integer> upRows = triangle.get(i - 1);
            currentRows = new ArrayList<>(i);
            currentRows.add(1);
            for (int j = 1; j < i; j++) {
                currentRows.add(upRows.get(j) + upRows.get(j - 1));
            }
            currentRows.add(1);
            triangle.add(currentRows);
        }

        return triangle;
    }
}
