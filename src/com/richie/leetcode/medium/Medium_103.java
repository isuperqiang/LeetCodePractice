package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.10.28
 */
public class Medium_103 {
    /**
     * 二叉树的锯齿形层次遍历
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * </p>
     *
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * //    3
     * //   / \
     * //  9  20
     * //    /  \
     * //   15   7
     * 返回锯齿形层次遍历如下：
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     * </p>
     *
     * <p>
     * 解答：
     * 题目 102 的变形，使用一个 bool 标记奇偶层次，决定将元素插入头部还是尾部。
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
        List<List<Integer>> lists = new Medium_103().zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        LinkedList<Integer> level;
        boolean toggle = false;
        while (!queue.isEmpty()) {
            level = new LinkedList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode head = queue.poll();
                if (toggle) {
                    level.addFirst(head.val);
                } else {
                    level.addLast(head.val);
                }
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
            toggle = !toggle;
        }
        return result;
    }
}
