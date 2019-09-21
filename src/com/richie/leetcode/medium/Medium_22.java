package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Richie on 2019.09.21
 */
public class Medium_22 {
    /**
     * 生成括号
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/generate-parentheses/
     * </p>
     *
     * <p>
     * 描述：
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * </p>
     *
     * <p>
     * 示例：
     * 例如，给出 n = 3，生成结果为：
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     * </p>
     *
     * <p>
     * 解答：
     * 回溯法。
     * 生成 N 对括号，必然有 N 个左括号和 N 个右括号，左括号的数量大于等于右括号。要确定 N 对，首先确定 N-1 对，利用递归求解。
     * left 记录左括号的数量，right 记录右括号的数量，当左右括号的数量相等时，记录结果，结束递归。
     * </p>
     */

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    private static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String curr, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(curr);
            return;
        }

        if (left < n) {
            generate(result, curr + "(", left + 1, right, n);
        }
        if (right < left) {
            generate(result, curr + ")", left, right + 1, n);
        }
    }

}
