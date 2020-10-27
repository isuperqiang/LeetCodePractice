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
     * 地址：https://leetcode-cn.com/problems/balanced-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * </p>
     *
     * <p>
     * 解答：
     * 平衡二叉树的条件：
     * - 左子树是平衡二叉树
     * - 右子树是平衡二叉树
     * - 左右子树的高度差的绝对值不超过 1
     * 深度优先遍历，递归求解树的高度。终止条件是不满足上述三个条件之一，二叉树的最大深度可以参考第 104 题。
     * 返回值 -1 代表不是平衡二叉树，大于 0 时代表二叉树的最大深度。
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
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        boolean balanced = new Easy_110().isBalanced(root);
        System.out.println(balanced); // true
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
