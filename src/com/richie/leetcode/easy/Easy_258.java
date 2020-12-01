package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.15
 */
public class Easy_258 {
    /**
     * 各位相加
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/add-digits/
     * </p>
     *
     * <p>
     * 描述：给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * 进阶：你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     * <p>
     *
     * <p>
     * 解答：
     * - 解法一：直接按题目意思来做，对数字对每位进行相加，结果不为一位数时一直循环。
     * - 解法二：比较巧妙。假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，经过一次各位相加后，变为s2 = a + b + c，
     * 减小的差值为(s1 -s2) = 99 * a + 9 * b，差值可以被9整除，每个循环都这样，缩小了9的倍数。当num小于9，即只有一位时，直接返回num，
     * 大于9时，如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），如果不能被整除，就返回被9除的余数。
     * </p>
     */

    public static void main(String[] args) {
        int i = addDigits1(38);
        System.out.println(i); // 3 + 8 = 11, 1 + 1 = 2
    }

    private static int addDigits1(int num) {
        int sum = 10;
        while (sum >= 10) {
            sum = 0;
            int n = num;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            num = sum;
        }
        return sum;
    }

    private static int addDigits2(int num) {
        if (num > 9) {
            num = num % 9;
            if (num == 0) {
                num = 9;
            }
        }
        return num;
    }

}
