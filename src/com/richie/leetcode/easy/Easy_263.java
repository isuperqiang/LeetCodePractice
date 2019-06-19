package com.richie.leetcode.easy;

/**
 * @author Richie on 2019.06.20
 */
public class Easy_263 {
    /**
     * 丑数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/ugly-number/
     * </p>
     *
     * <p>
     * 描述：编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 6
     * 输出: true
     * 解释: 6 = 2 × 3
     * </p>
     *
     * <p>
     * 解答：
     * - 解法一：循环实现
     * - 解法二：递归实现
     * </p>
     */

    public static void main(String[] args) {
        boolean ugly = isUgly(14);
        System.out.println(ugly); // false
    }

    private static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    private static boolean isUgly2(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        if (num % 2 == 0) {
            return isUgly2(num / 2);
        }
        if (num % 3 == 0) {
            return isUgly2(num / 3);
        }
        if (num % 5 == 0) {
            return isUgly2(num / 5);
        }
        return false;
    }

}
