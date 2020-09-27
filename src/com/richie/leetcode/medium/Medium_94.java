package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Richie on 2020.09.27
 */
public class Medium_94 {
    /**
     * 二叉树的中序遍历
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，返回它的中序 遍历。
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
     * <p>
     * 输出: [1,3,2]
     * </p>
     *
     * <p>
     * 解答：
     * - 递归
     * - 迭代
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(h)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new Medium_94().inorderTraversal2(root);
        System.out.println(list); // [1,3,2]
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalInner(root, result);
        return result;
    }

    private void inorderTraversalInner(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalInner(root.left, result);
        result.add(root.val);
        inorderTraversalInner(root.right, result);
    }

}
