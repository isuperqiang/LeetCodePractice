package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.25
 */
public class E_021 {
    /**
     * 二叉树的最大深度
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * </p>
     *
     * <p>
     * 解答：如果二叉树为空，则深度为 0。
     * 如果不为空，分别求出左子树和右子树的深度，取最大值加上根节点深度 1。
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r21 = new TreeNode(15);
        TreeNode r22 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        r1.left = r21;
        r1.right = r22;

        int depth = maxDepth(root);
        System.out.println(depth);
        // 3
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
