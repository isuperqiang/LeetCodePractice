package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.08
 */
public class E_012 {
    /**
     * 验证回文字符串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/valid-palindrome/description/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * </p>
     *
     * <p>
     * 解答：定义头尾指针，从头尾遍历字符串，非数字/字母则跳过，判断字符是否相等。
     * </p>
     */

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
        // true
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            char headC = chars[head];
            char tailC = chars[tail];
            if (!Character.isLetterOrDigit(headC)) {
                head++;
            } else if (!Character.isLetterOrDigit(tailC)) {
                tail--;
            } else {
                if (headC != tailC) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
