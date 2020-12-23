package com.richie.leetcode.offer;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.12.23
 */
public class Offer_27 {
    /**
     * 二叉树的镜像
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * //      4
     * //    /   \
     * //   2     7
     * //  / \   / \
     * // 1   3 6   9
     * 输出：
     * //      4
     * //    /   \
     * //   7     2
     * //  / \   / \
     * // 9   6 3   1
     * </p>
     *
     * <p>
     * 解答：
     * 递归，详解见 226 题
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode ans = new Offer_27().mirrorTree(root);
        System.out.println(ans);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = mirrorTree(root.left);
        TreeNode left = mirrorTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
