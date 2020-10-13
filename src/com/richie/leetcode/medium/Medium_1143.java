package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.07.11
 */
public class Medium_1143 {
    /**
     * 最长公共子序列
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/longest-common-subsequence/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个字符串text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     * 若这两个字符串没有公共子序列，则返回 0。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * </p>
     *
     * <p>
     * 解答：动态规划
     * - dp[i][j] 表示字符串 s1 前 i 个字符 和 s2 前 j 个字符的最长公共子序列长度；
     * - dp[0][j] 和 dp[i][0] 都初始化为 0，因为假定第一个字符是空字符；
     * - 如果 Si 最后一个字符等于 Tj 最后一个字符，那么 dp[i][j]=dp[i-1][j-1]+1，否则就是 dp[i-1][j] 和 dp[i][j-1] 的最大值；
     * - dp[len(s1)][len(s2)] 就是结果
     * </p>
     *
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * </p>
     */

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int lcs = new Medium_1143().longestCommonSubsequence(text1, text2);
        System.out.println(lcs); // 3
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
