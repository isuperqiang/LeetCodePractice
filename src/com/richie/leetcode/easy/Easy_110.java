package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2019.08.04
 */
public class Easy_110 {
    /**
     * 平衡二叉树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/balanced-binary-tree/comments/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
     * </p>
     *
     * <p>
     * 解答：
     * 平衡二叉树的条件：
     * - 左子树是平衡二叉树
     * - 右子树是平衡二叉树
     * - 左右子树的高度差的绝对值不超过 1
     * <p>
     * 深度优先遍历，递归求解树的高度。终止条件是不满足上述三个条件之一，二叉树的最大深度可以参考第 114 题。
     *
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1
                || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
