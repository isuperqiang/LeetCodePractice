package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 二叉树的右视图
 *
 * @author Richie on 2020.12.02
 */
public class Medium_199 {

    //    输入: [1,2,3,null,5,null,4]
//    输出: [1, 3, 4]
//              1            <---
//            /   \
//            2     3         <---
//             \     \
//              5     4       <---
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> list = new Medium_199().rightSideView(root);
        System.out.println(list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode first = queue.pop();
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
                if (i == size - 1) {
                    result.add(first.val);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        ++depth;
        dfs(root.right, result, depth);
        dfs(root.left, result, depth);
    }
}
