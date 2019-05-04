package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.04
 */
public class Easy_231 {
    /**
     * 2 的幂
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/power-of-two/
     * </p>
     *
     * <p>
     * 描述：给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 16
     * 输出: true
     * 解释: 2^4 = 16
     * </p>
     *
     * <p>
     * 解答：如果一个数是2的幂次，那么它的二进制表示一定只有一个1。比如8的二进制 00001000，现在把这个数减1，得到 00000111。
     * 发现低4位是按位取反，这时候（n&n-1）的结果就一定是0。如果一个数不是2的幂次，那么它的二进制数里1的个数就大于1（0除外）。
     * n和n-1就不会出现左边都是0的现象了，n&(n-1)一定不是0。
     * </p>
     */

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(16);
        System.out.println(powerOfTwo); // false
    }

    private static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
