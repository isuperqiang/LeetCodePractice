package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.14
 */
public class Easy_69 {
    /**
     * X 的平方根
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/sqrtx/
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
     * 解答：二分法
     * 设定上界为 x，下界为 0，每次比较中间值的平方和 x 的关系，取较小的中间值。注意整型溢出，变量类型声明为 long。
     * </p>
     *
     * <p>
     * - 时间复杂度：O(logN)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int i = new Easy_69().mySqrt(99);
        System.out.println(i); // 9
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long l = 0, r = x, ans = -1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long pow = mid * mid;
            if (pow <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}
