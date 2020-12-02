package com.richie.leetcode.easy;

/**
 * @author richie on 2018.05.31
 */
public class Easy_7 {
    /**
     * 反转整数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/reverse-integer/description/
     * </p>
     *
     * <p>
     * 描述：给定一个 32 位有符号整数，将整数中的数字进行反转。
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * </p>
     *
     * <p>
     * 解答：把原数字先对10求余，再将求余后的数字乘以10加上结果数字和，再将原数字除以10，重复以上步骤，直到原数字等于0。
     * 越界通过与整形的最大值、最小值的比较来判断。
     * </p>
     */

    public static void main(String[] args) {
        int a = 123;
        int b = reverse(a);
        System.out.println(b);
        // 输出：321
    }

    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int d = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + d;
            x /= 10;
        }
        return result;
    }
}
