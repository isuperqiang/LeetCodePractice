package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.06.13
 */
public class Easy_66 {
    /**
     * 加一
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/plus-one/description/
     * </p>
     *
     * <p>
     * 描述：给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * </p>
     *
     * <p>
     * 解答：分两种情况讨论：
     * 最高位进位，
     * 若最高位进位，那么比他低的位数字都为9，且加1后都为0，需要初始化一个长度为(lenght+1)的新数组，0位置为1代表进位。
     * 最高位不进位，
     * 若最高位不进位，那么不需要产生新数组，后续数字由更低位计算而来。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] ret = plusOne(nums);
        System.out.println(Arrays.toString(ret));
        //[1, 2, 4]
    }

    private static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
        }

        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
