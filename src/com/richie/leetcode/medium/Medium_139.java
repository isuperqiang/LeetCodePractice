package com.richie.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Richie on 2020.10.12
 */
public class Medium_139 {
    /**
     * 单词拆分
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/word-break/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 说明：
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * </p>
     *
     * <p>
     * 解答：动态规划
     * - dp[i] 表示字符串 s 的前 i 个字符能否被拆分成字典中的单词
     * - 初始化 dp[0]=true，表示可以拆分成空字符
     * - 状态转移方程 dp[i]=dp[j] && check(s[j..i−1])
     * - 一旦检查到可以拆分，就跳出内层循环，继续下一个字符
     * </p>
     *
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean b = new Medium_139().wordBreak(s, wordDict);
        System.out.println(b); // true
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
