package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.09.27
 */
public class Medium_94 {
    /**
     * 二叉树的中序遍历
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，返回它的中序遍历。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,null,2,3]
     * //   1
     * //    \
     * //     2
     * //    /
     * //   3
     * <p>
     * 输出: [1,3,2]
     * </p>
     *
     * <p>
     * 解答：
     * - 递归：递归终止条件 root 为空，递归左子树，打印当前节点，递归右子树；
     * - 迭代：不断往左子树走，将当前节点保存到栈中，直到当前节点为空。从栈中弹出节点并保存，然后转到节点到右子树；
     * </p>
     *
     * <p>
     * - 递归：
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
        List<Integer> result = new Medium_94().inorderTraversal2(root);
        System.out.println(result); // [1,3,2]
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode top = stack.pop();
                result.add(top.val);
                root = top.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }
}
