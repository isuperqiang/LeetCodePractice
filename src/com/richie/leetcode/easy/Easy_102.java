package com.richie.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author richie on 2018.06.29
 */
public class Easy_102 {
    /**
     * 二叉树的层次遍历
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * </p>
     *
     * <p>
     * 解答：每次访问节点的时候，如果该结点有子结点，则把该结点的子结点放到一个队列的尾部。接下来从队列的头部取出最早放入队列的结点，
     * 放在一个list中，队列保存当前层的元素。重复前面的操作，直到队列中所有的结点都访问完成为止。
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r21 = new TreeNode(20);
        root.left = l1;
        root.right = r21;
        TreeNode r31 = new TreeNode(15);
        TreeNode r32 = new TreeNode(7);
        r21.left = r31;
        r21.right = r32;

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
        // [[3], [9, 20], [15, 7]]
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        if (root == null) {
            return tree;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list;
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head != null) {
                    list.add(head.val);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
            }
            tree.add(list);
        }
        return tree;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
