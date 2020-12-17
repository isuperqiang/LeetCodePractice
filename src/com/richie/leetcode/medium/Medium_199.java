package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.12.02
 */
public class Medium_199 {
    /**
     * 二叉树的右视图
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * //     1            <---
     * //   /   \
     * //  2     3         <---
     * //   \     \
     * //    5     4       <---
     * </p>
     *
     * <p>
     * 解答：
     * - BFS：广度优先遍历，记录每层最后一个元素。
     * - DFS：深度优先遍历，按照根右左的顺序，记录当前节点的深度。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> ans = new Medium_199().rightSideView(root);
        System.out.println(ans);
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
        depth++;
        dfs(root.right, result, depth);
        dfs(root.left, result, depth);
    }
}
