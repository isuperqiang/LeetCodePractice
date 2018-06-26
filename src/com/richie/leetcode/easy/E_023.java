package com.richie.leetcode.easy;

import java.util.LinkedList;

/**
 * @author richie on 2018.06.26
 */
public class E_023 {
    /**
     * 有效的括号
     *
     * <p>
     * 地址：
     * </p>
     *
     * <p>
     * 描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * </p>
     *
     * <p>
     * 解答：利用栈的「后进先出」的特点，将左括号压栈，然后和最近的右括号匹配。匹配成功则出栈，继续匹配下一个，否则算作失败。
     * 完全匹配时，最后的栈为空，即为有效的括号。
     * </p>
     */

    public static void main(String[] args) {
        String s = "()[";
        boolean valid = isValid(s);
        System.out.println(valid);
        // false
    }

    private static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        if (!(s.startsWith("(") || s.startsWith("{") || s.startsWith("["))) {
            return false;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                Character peek = stack.peek();
                if (peek != null && isMatch(peek, aChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        return false;
    }
}
