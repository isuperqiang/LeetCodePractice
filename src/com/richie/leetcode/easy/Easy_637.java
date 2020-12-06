package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.12.07
 */
public class Easy_637 {
    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * //    3
     * //   / \
     * //  9  20
     * //    /  \
     * //   15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     * </p>
     *
     * <p>
     * 解答：BFS
     * 广度优先遍历，计算每层的元素和，并求平均值。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Double> ans = new Easy_637().averageOfLevels(root);
        System.out.println(ans);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                sum += head.val;
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
