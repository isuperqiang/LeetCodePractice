package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.09.29
 */
public class Medium_102 {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。（即逐层地，从左到右访问所有节点）。
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 二叉树的层序遍历
     * </p>
     *
     * <p>
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * //    3
     * //   / \
     * //  9  20
     * //    /  \
     * //   15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * </p>
     *
     * <p>
     * 解答：借助队列
     * 在每层遍历开始前，先记录队列中的节点数量 n，也就是这层的节点数量，然后一口气处理完这层的 n 个节点。
     * 在每轮 while 循环中，都是将当前层的所有节点出队列，再将下层的所有节点入队列，这样就实现了层序遍历。
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
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new Medium_102().levelOrder(root);
        System.out.println(lists); // [[3], [9, 20], [15, 7]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> level;
        queue.offer(root);
        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }

}
