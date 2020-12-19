package com.richie.leetcode.offer;

/**
 * @author Richie on 2020.12.19
 */
public class Offer_64 {
    /**
     * 求1+2+…+n
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: n = 3
     * 输出: 6
     * </p>
     *
     * <p>
     * 解答：
     * 利用逻辑运算符的短路特性，作为流程的条件语句。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int ans = new Offer_64().sumNums(3);
        System.out.println(ans);
    }

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
