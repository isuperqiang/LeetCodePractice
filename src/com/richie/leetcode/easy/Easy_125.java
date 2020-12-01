package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.08
 */
public class Easy_125 {
    /**
     * 验证回文串
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/valid-palindrome/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 本题中，我们将空字符串定义为有效的回文串。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * </p>
     *
     * <p>
     * 解答：双指针
     * 定义头尾指针，从两端分别遍历字符串，非数字/字母则跳过，判断字符是否相等。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome); // true
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char headC = s.charAt(head);
            char tailC = s.charAt(tail);
            if (!Character.isLetterOrDigit(headC)) {
                head++;
                continue;
            }
            if (!Character.isLetterOrDigit(tailC)) {
                tail--;
                continue;
            }
            if (headC != tailC) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
