package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.14
 */
public class Easy_69 {
    /**
     * X 的平方根
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/sqrtx/
     * </p>
     *
     * <p>
     * 描述：实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * 输入 4 返回 2，输入 8 返回 2
     * </p>
     *
     * <p>
     * 解答：牛顿法 https://en.wikipedia.org/wiki/Integer_square_root
     * 注意整形边界，防止出现越界。
     * </p>
     */

    public static void main(String[] args) {
        int x = 99;
        int i = mySqrt(x);
        System.out.println(i); // 9
    }

    private static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int r = x / 2;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
