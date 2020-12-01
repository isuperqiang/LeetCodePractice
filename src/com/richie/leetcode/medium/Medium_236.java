package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.10.28
 */
public class Medium_236 {
    /**
     * 二叉树的最近公共祖先
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * </p>
     *
     * <p>
     * 示例：
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * </p>
     *
     * <p>
     * 解答：
     * 若 root 是 p、q 的最近公共祖先，包括以下三种情况：
     * - p 和 q 在 root 的子树中，并且一个在左子树，另一个在右子树；
     * - p 等于 root，q 在 root 的左子树或右子树中；
     * - q 等于 root，p 在 root 的左子树或右子树中；
     * 递归遍历二叉树，遇到 p 或 q 时返回 root。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode treeNode = new Medium_236().lowestCommonAncestor(root, root.left, root.right);
        System.out.println(treeNode != null ? treeNode.val : "null"); // 3
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
