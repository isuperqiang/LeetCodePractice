package com.richie.leetcode.easy;

/**
 * @author richie on 2018.05.31
 */
public class E_004 {
    /**
     * 反转整数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-integer/description/
     * </p>
     *
     * <p>
     * 描述：给定一个 32 位有符号整数，将整数中的数字进行反转。
     * </p>
     *
     * <p>
     * 解答：把整数当作字符串反转，然后再转换成整数
     * </p>
     */

    public static void main(String[] args) {
        int a = 123;
        int b = reverse(a);
        System.out.println(b);
        // 输出：321
    }

    private static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int length = chars.length;
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }

        int reverted = 0;
        try {
            reverted = Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (negative) {
            reverted = -reverted;
        }
        return reverted;
    }
}
