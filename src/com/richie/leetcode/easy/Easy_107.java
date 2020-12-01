package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author richie on 2019.05.22
 */
public class Easy_107 {
    /**
     * 二叉树的层次遍历 II
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * </p>
     *
     * <p>
     * 例如，给定二叉树 [3,9,20,null,null,15,7],
     * //     3
     * //    / \
     * //   9  20
     * //    /  \
     * //   15   7
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
        List<List<Integer>> lists = new Easy_107().levelOrderBottom(root);
        System.out.println(lists); // [[15, 7], [9, 20], [3]]
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<>();
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
            result.add(0, level);
        }
        return result;
    }
}
