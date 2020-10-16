package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.10.16
 */
public class Medium_144 {
    /**
     * 二叉树到前序遍历
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，返回它的 前序 遍历。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * 输出: [1,2,3]
     * </p>
     *
     * <p>
     * 解答：
     * - 递归
     * - 迭代
     * 借助栈到后进先出特性，从根节点开始，每次迭代弹出栈顶元素，并把子节点压栈，注意先压右子点再压左子节点。
     * </p>
     *
     * <p>
     * - 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * - 迭代：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new Medium_144().preorderTraversal2(root);
        System.out.println(result);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.removeLast();
            result.add(top.val);
            if (top.right != null) {
                stack.addLast(top.right);
            }
            if (top.left != null) {
                stack.addLast(top.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursive(root, result);
        return result;
    }

    private void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }
}
