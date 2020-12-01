package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.11.22
 */
public class Easy_235 {
    /**
     * 二叉搜索树的最近公共祖先
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * </p>
     *
     * <p>
     * 示例：
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * </p>
     *
     * <p>
     * 解答：
     * 利用二叉搜索树的性质：左子树小于根节点，右子树大于根节点。
     * - 如果 p 和 q 都小于根节点，说明 p 和 q 在左子树，更新根节点为左子树；
     * - 如果 p 和 q 都大于根节点，说明 p 和 q 在右子树，更新根节点为右子树；
     * - 否则，p 和 q 要么在当根节点都左右两边，或者就是其中一个就是根节点。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = new Easy_235().lowestCommonAncestor(root, root.left, root.right);
        System.out.println(treeNode != null ? treeNode.val : "null"); // 6
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            root = lowestCommonAncestor2(root.left, p, q);
        } else if (p.val > root.val && q.val < root.val) {
            root = lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
}
