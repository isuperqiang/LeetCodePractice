package com.richie.leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author richie on 2019.05.22
 */
public class Easy_107 {
    /**
     * 二叉树的层次遍历 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * </p>
     *
     * <p>
     * 例如，给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * /   \
     * 9    20
     * / \
     * 15  7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     * </p>
     *
     * <p>
     * 解答：广度优先，逐层遍历。
     * </p>
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrderBottom(root);
        System.out.println(lists);
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();
        List<TreeNode> rowList;
        nodeList.add(root);

        List<Integer> levelList;
        while (nodeList.size() > 0) {
            levelList = new LinkedList<>();
            rowList = new LinkedList<>();
            for (TreeNode treeNode : nodeList) {
                levelList.add(treeNode.val);
                if (treeNode.left != null) {
                    rowList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    rowList.add(treeNode.right);
                }
            }

            result.add(0, levelList);
            nodeList = rowList;
        }
        return result;
    }

    /*
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
            return "val: " + val;
        }
    }
}
