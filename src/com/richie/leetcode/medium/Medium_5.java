package com.richie.leetcode.medium;

/**
 * @author Richie on 2018.05.29
 */
public class Medium_5 {
    /**
     * 最长回文子串
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
     * </p>
     *
     * <p>
     * 描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * </p>
     *
     * <p>
     * 解答：
     * - 动态规划
     * 定义状态 dp[i][j] 表示子串 s[i][j] 是否是回文子串，其中 i<=j。
     * 状态转移方程 dp[i][j]=dp[i+1][j-1] && s[i]==s[j]。
     * 边界条件 dp[i+1][j-1] 构成区间 (j-1)-(i+1)+1 >= 2。
     * 初始化 dp[i][i]=true，单个字符一定是回文串。
     * 只要得到 dp[i][j]=true，就记录起始位置和回文长度，最后才做字符串截取。
     * - 中心扩展
     * 由于回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+(n-1) 个中心。
     * </p>
     *
     * <p>
     * - 动态规划：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * <p>
     * - 中心扩展：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String s = "babad";
        String palindrome = new Medium_5().longestPalindrome(s);
        System.out.println(palindrome);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int left = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if ((j - 1) - (i + 1) + 1 >= 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
                int currLen = j - i + 1;
                if (dp[i][j] && currLen > maxLen) {
                    maxLen = currLen;
                    left = i;
                }
            }
        }
        return s.substring(left, left + maxLen);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return (R - 1) - (L + 1) + 1;
    }
}
