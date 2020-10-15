package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.10.15
 */
public class Medium_131 {
    /**
     * 分割回文串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/palindrome-partitioning/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 和组合问题类似，可以用回溯算法。
     * - 分割点从头到尾，产品子串之前，先判断是否是回文串
     * - 结束条件，分割点等于字符串长度
     * </p>
     *
     * <p>
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        List<List<String>> lists = new Medium_131().partition("aab");
        System.out.println(lists); // [[a, a, b], [aa, b]]
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(result, s, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(List<List<String>> result, String s, Deque<String> path, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start, len = s.length(); i < len; i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrack(result, s, path, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
