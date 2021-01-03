package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.26
 */
public class Easy_191 {
    /**
     * 位 1 的个数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits/
     * </p>
     *
     * <p>
     * 描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
     * </p>
     *
     * <p>
     * 示例：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * </p>
     *
     * <p>
     * 解答：
     * - 逐位判断
     * 判断 n 最右一位是否为 1，如果是 1 结果加 1；将 n 右移一位，这里使用无符号右移。
     * - n&(n-1)
     * 这个运算的结果是，二进制数字 n 最右边的 1 变成 0，其余不变。
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */

    public static void main(String[] args) {
        int ans = new Easy_191().hammingWeight2(0b00000000000000000000000000001011);
        System.out.println(ans);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            ++ans;
            n &= n - 1;
        }
        return ans;
    }
}
