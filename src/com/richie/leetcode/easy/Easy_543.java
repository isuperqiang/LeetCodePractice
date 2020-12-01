package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.12.01
 */
public class Easy_543 {
    /**
     * 二叉树的直径
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/diameter-of-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     * </p>
     *
     * <p>
     * 示例：
     * 给定二叉树
     * //          1
     * //         / \
     * //        2   3
     * //       / \
     * //      4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * </p>
     *
     * <p>
     * 解答：
     * 深度优先搜索。使用一个全局变量记录结果，递归计算树的深度，比较结果和左右子树的路径和大小，然后更新结果。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，h 树的高度
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        int result = new Easy_543().diameterOfBinaryTree(root);
        System.out.println(result);
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
