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
     * 解答：广度优先，逐层遍历。首先构建数据列表和下层结点列表，遍历当前层的结点列表，把数据添加到数据列表，并把每个结点的子结点添加到下层结点列表。
     * 遍历完成后，把数据列表放到结果列表的首部，然后把下层结点列表变成当前结点列表，继续遍历。
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
        List<TreeNode> currRowList = new LinkedList<>();
        currRowList.add(root);
        List<TreeNode> nextRowList;
        List<Integer> valueList;
        while (currRowList.size() > 0) {
            valueList = new LinkedList<>();
            nextRowList = new LinkedList<>();
            for (TreeNode treeNode : currRowList) {
                valueList.add(treeNode.val);
                if (treeNode.left != null) {
                    nextRowList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextRowList.add(treeNode.right);
                }
            }
            result.add(0, valueList);
            currRowList = nextRowList;
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
