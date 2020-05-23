package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.05.23
 */
public class Easy_112 {
    /**
     * 路径总和
     * <p>
     * 地址：https://leetcode-cn.com/problems/path-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * </p>
     *
     * <p>
     * 示例：
     * 给定如下二叉树，以及目标和 sum = 22，返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * </p>
     *
     * <p>
     * 解答：
     * 递归。从根节点开始遍历，每次遍历时从目标和减去当前节点值，当作子节点要凑的和，在叶子节点判断是否刚好凑齐。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(Log(N)) or O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        boolean b = hasPathSum(root, 22);
        System.out.println(b); // true
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        int csum = sum - root.val;
        return hasPathSum(root.left, csum) || hasPathSum(root.right, csum);
    }
}
