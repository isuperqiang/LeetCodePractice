package com.richie.leetcode.easy;

/**
 * @author richie on 2019.06.07
 */
public class Easy_326 {
    /**
     * 3 的幂
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/power-of-three/
     * </p>
     *
     * <p>
     * 描述：给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * </p>
     *
     * <p>
     * 解答：
     * 解法一：累乘法
     * 解法二：3的幂次质因子只有3，而整数范围内的3的幂次最大是1162261467
     * </p>
     */

    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(127);
        System.out.println(powerOfThree);
    }

    private static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        long m = 1;
        while (m < n) {
            m *= 3;
            if (m == n) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
