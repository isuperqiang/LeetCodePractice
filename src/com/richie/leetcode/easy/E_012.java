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
     * 解答：先从字符串提取出字符和数字，然后对新的字符串进行处理，比较中轴两边的字符是否相等。
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

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(chars[i]) || Character.isLetter(chars[i])) {
                stringBuilder.append(chars[i]);
            }
        }
        String newS = stringBuilder.toString();
        char[] newChars = newS.toCharArray();
        int newLength = newChars.length;
        for (int i = 0; i < newLength / 2; i++) {
            if (Character.toLowerCase(newChars[i]) != Character.toLowerCase(newChars[newLength - i - 1])) {
                return false;
            }
        }
        return true;
    }
}
