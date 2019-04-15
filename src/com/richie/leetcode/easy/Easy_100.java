package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.15
 */
public class Easy_100 {
    /**
     * 相同的树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/same-tree/
     * </p>
     *
     * <p>
     * 描述：给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * </p>
     *
     * <p>
     * 解答：两个树相同的条件 1.当前节点的值相等；2.每棵树的左子树和另一棵树的左子树相同；3.每棵树的右子树和另一棵树的右子树相同
     * </p>
     */

    public static void main(String[] args) {
        TreeNode treeNode1 = initTreeNode1();
        TreeNode treeNode2 = initTreeNode2();
        boolean sameTree = isSameTree(treeNode1, treeNode2);
        System.out.println(sameTree); // false
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            boolean valEq = p.val == q.val;
            return valEq && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /*
     *    1
     *  /   \
     * 2     3
     *
     */
    private static TreeNode initTreeNode1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        return root;
    }

    /*
     *    1
     *  /
     * 2
     *
     */
    private static TreeNode initTreeNode2() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        return root;
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
    }

}
