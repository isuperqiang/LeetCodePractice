package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author richie on 2018.06.25
 */
public class Easy_104 {
    /**
     * 二叉树的最大深度
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * </p>
     *
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * //      3
     * //     / \
     * //    9  20
     * //   /    \
     * //  15    7
     * 返回它的最大深度 3 。
     * </p>
     *
     * <p>
     * 解答：递归
     * - 终止条件：二叉树为空，深度是 0。
     * - 递归循环：分别求出左右子树的深度，取最大值加上根节点深度 1。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int depth = new Easy_104().maxDepth(root);
        System.out.println(depth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
