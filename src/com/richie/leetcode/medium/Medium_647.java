package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.10.20
 */
public class Medium_647 {
    /**
     * 回文子串
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/palindromic-substrings/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * </p>
     *
     * <p>
     * 示例：
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     * </p>
     *
     * <p>
     * 解答：动态规划
     * - dp[][] 表示子串 s[i][j] 是否是回文子串，数组长度为字符串的长度
     * - 初始化 dp[][] = false
     * - 状态转移方程。i==j 时，s[i][j]是回文串；i=j+1&&s[i]==s[j] 时，s[i][j]是回文串；i>j+1&&s[i]==s[j]&&dp[i-1][j+1] 时，s[i][j]是回文串
     * - 返回回文子串的个数
     * 优化方案，dp改为一维数组
     * </p>
     *
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * </p>
     */
    public static void main(String[] args) {
        int i = new Medium_647().countSubstrings("aaa");
        System.out.println(i); // 6
    }

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i - j == 1 && b) {
                        dp[i][j] = true;
                        count++;
                    } else if (i - j > 1 && b && dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
