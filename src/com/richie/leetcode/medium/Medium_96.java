package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.29
 */
public class Medium_96 {
    /**
     * 不同的二叉搜索树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/unique-binary-search-trees/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * </p>
     *
     * <p>
     * 解答：动态规划
     * dp[i] 表示以 1...i 为节点组成的二叉搜索树个数，选择 k 作为根结点，则 1...k-1 位于左子树，k+1...n 位于右子树，左右子树相互独立；
     * dp[i]=sum(dp[k-1]*dp[i-k])，1<=k<=i，即节点 k 在 1...n 之间滑动，每移动一次，左右子树重新组合。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int i = new Medium_96().numTrees(3);
        System.out.println(i); // 5
    }

    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
