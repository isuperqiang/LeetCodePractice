package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.12.05
 */
public class Easy_9 {
    /**
     * 回文数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/palindrome-number/
     * </p>
     *
     * <p>
     * 描述：
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 121
     * 输出: true
     * </p>
     *
     * <p>
     * 解答：
     * 反转一半数字，判断反转后的整数和前半段整数是否相等，注意处理奇偶性。
     * </p>
     *
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        boolean palindrome = new Easy_9().isPalindrome(121);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        return x == reverted || x == reverted / 10;
    }
}
