package com.richie.leetcode.hard;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.10.28
 */
public class Hard_124 {
    /**
     * 二叉树中的最大路径和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个非空二叉树，返回其最大路径和。
     * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：[1,2,3]
     * //       1
     * //      / \
     * //     2   3
     * <p>
     * 输出：6
     * </p>
     *
     * <p>
     * 解答：递归
     * - 当前节点最大路径和计算：以当前节点为起点的所有路径和
     * - 当前节点对上一层的贡献：只能选择当前节点的最大的一条路径作为贡献，因为路径节点不可重复
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int maxPathSum = new Hard_124().maxPathSum(root);
        System.out.println(maxPathSum); // 6
    }

    private int mMaxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return mMaxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        mMaxPathSum = Math.max(mMaxPathSum, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
